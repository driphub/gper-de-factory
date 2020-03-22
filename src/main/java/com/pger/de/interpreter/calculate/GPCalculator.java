package com.pger.de.interpreter.calculate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GPCalculator {
    private NumStack stack = new NumStack();
    private List<String> rpnList = new ArrayList<String>();

    public GPCalculator(String expression) {
        this.parse(expression);
    }

    private void parse(String expression) {
        IArithmeticInterpreter leftExpr, rightExpr;
//        String[] elements = expression.split(" ");
//        int length = elements.length;
//
//        for (int i = 0; i < length; i++) {
//            String operator = elements[i];
//            if (OperatorUtil.isOperator(operator)) {
//                leftExpr = this.stack.pop();
//                rightExpr = new NumInterpreter(Integer.valueOf(elements[++i]));
//                System.out.println("出栈: " + leftExpr.interpret() + " 和 " + rightExpr.interpret());
//                this.stack.push(OperatorUtil.getInterpreter(leftExpr, rightExpr, operator));
//                System.out.println("应用运算符: " + operator);
//            } else {
//                NumInterpreter numInterpreter = new NumInterpreter(Integer.valueOf(elements[i]));
//                this.stack.push(numInterpreter);
//                System.out.println("入栈: " + numInterpreter.interpret());
//            }
//        }

        createRnp(expression);

        int length = rpnList.size();
        for (int i = 0; i < length; i++) {
            String op = rpnList.get(i);
            if (!OperatorUtil.isNumber(op)) {
                leftExpr = this.stack.pop();
                rightExpr = this.stack.pop();
                System.out.println("出栈: " + leftExpr.interpret() + " 和 " + rightExpr.interpret());
                this.stack.push(OperatorUtil.getInterpreter(rightExpr, leftExpr, op));
                System.out.println("应用运算符: " + op);
            } else {
                NumInterpreter numInterpreter = new NumInterpreter(Integer.valueOf(rpnList.get(i)));
                this.stack.push(numInterpreter);
                System.out.println("入栈: " + numInterpreter.interpret());
            }
        }
    }

    private void createRnp(String expression) {
        String[] elements = expression.split(" ");
        int length = elements.length;
        RpnStack stack = new RpnStack();
        for (int i = 0; i < length; i++) {
            String operator = elements[i];
            if (OperatorUtil.isNumber(operator)) {
                rpnList.add(operator);
            } else {
                // 左括号，压栈
                if (OperatorUtil.isParenthesesStart(operator)) {
                    stack.push(operator);
                } else if (OperatorUtil.isParenthesesEnd(operator)) {
                    // 右括号，出栈，直到栈内为空或者出现第一个左括号
                    while (!stack.isEmpty()) {
                        String temp = stack.pop();
                        if (!OperatorUtil.OPSTART.equals(temp)) {
                            rpnList.add(temp);
                        } else {
                            break;
                        }
                    }
                } else {
                    if (stack.isEmpty()) {
                        // 压栈
                        stack.push(operator);
                    } else {
                        // 判断栈顶元素优先级
                        while (!stack.isEmpty() && OperatorUtil.compareOpt(stack.top(), operator)) {
                            rpnList.add(stack.pop());
                        }

                        // 压栈
                        stack.push(operator);
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            rpnList.add(stack.pop());
        }
        System.out.printf("------ 栈内计算元素 = " + rpnList);
    }

    /**
     * 计算元素栈
     *
     */
    private class RpnStack {
        LinkedList<String> stackList = new LinkedList<>();

        public RpnStack() {
        }

        /**
         * 入栈
         * @param expression
         */
        public void push(String expression) {
            stackList.addLast(expression);
        }

        /**
         * 出栈
         * @return
         */
        public String pop() {
            return stackList.removeLast();
        }

        /**
         * 栈顶元素
         * @return
         */
        public String top() {
            return stackList.getLast();
        }

        /**
         * 栈是否为空
         * @return
         */
        public boolean isEmpty() {
            return stackList.isEmpty();
        }
    }

    /**
     * 运算变量栈
     *
     */
    private class NumStack {
        LinkedList<IArithmeticInterpreter> list = new LinkedList<IArithmeticInterpreter>();

        public NumStack() {

        }

        /**
         * 入栈
         * @param interpret
         */
        public void push(IArithmeticInterpreter interpret) {
            list.addLast(interpret);
        }

        /**
         * 出栈
         * @return
         */
        public IArithmeticInterpreter pop() {
            return list.removeLast();
        }
    }

    public int calculate() {
        return this.stack.pop().interpret();
    }

}