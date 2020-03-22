package com.pger.de.interpreter.calculate;

public class OperatorUtil {
    /**
     * +
     */
    private final static String OP1 = "+";

    /**
     * -
     */
    private final static String OP2 = "-";

    /**
     * *
     */
    private final static String OP3 = "*";

    /**
     * /
     */
    private final static String OP4 = "/";

    /**
     * (
     */
    public final static String OPSTART = "(";

    /**
     * )
     */
    public final static String OPEND = ")";


    /**
     * 判断当前字符或字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        return str.startsWith("0") || str.startsWith("1") || str.startsWith("2")
                || str.startsWith("3") || str.startsWith("4") || str.startsWith("5")
                || str.startsWith("6") || str.startsWith("7") || str.startsWith("8")
                || str.startsWith("9") || str.startsWith(".");

    }

    /**
     * 判断当前字符是否是 (
     * @param str
     * @return
     */
    public static boolean isParenthesesStart(String str) {
        return OPSTART.equals(str);
    }

    /**
     * 判断当前字符是否是  )
     * @param str
     * @return
     */
    public static boolean isParenthesesEnd(String str) {
        return OPEND.equals(str);
    }

    /**
     * 判断当前字符是否是高优先级运算符  * /
     * @param str
     * @return
     */
    private static boolean isHeighOperator(String str) {
        if (OP3.equals(str) || OP4.equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean compareOpt(String str1, String str2) {
        if (OPSTART.equals(str1)) {
            return false;
        }
        if (isHeighOperator(str2)) {
            return false;
        } else {
            if (isHeighOperator(str1)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isOperator(String symbol) {
        return (OP1.equals(symbol) || OP2.equals(symbol) || OP3.equals(symbol) || OP4.equals(symbol));
    }

    public static Interpreter getInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right, String symbol) {
        switch (symbol) {
            case OP1:
                return new AddInterpreter(left, right);
            case OP2:
                return new SubInterpreter(left, right);
            case  OP3:
                return new MultiInterpreter(left, right);
            case OP4:
                return new DivInterpreter(left, right);
            default:
                break;
        }
        return null;
    }
}