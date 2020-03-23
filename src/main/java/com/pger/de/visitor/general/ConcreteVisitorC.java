package com.pger.de.visitor.general;

// 具体访问者
public class ConcreteVisitorC implements IVisitor {

    public void visit(ConcreteElementA element) {
        String result = element.operationA();
        System.out.println("result from " + element.getClass().getSimpleName() + ": " + result);
    }


    public void visit(ConcreteElementB element) {
        int result = element.operationB();
        System.out.println("result from " + element.getClass().getSimpleName() + ": " + result);
    }
}