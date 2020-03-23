package com.pger.de.visitor.general;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        ObjectStructure collection = new ObjectStructure();
        System.out.println("ConcreteVisitorA handle elements:");
        IVisitor visitorA = new ConcreteVisitorA();
        collection.accept(visitorA);

        System.out.println("------------------------------------");
        System.out.println("ConcreteVisitorB handle elements:");
        IVisitor visitorB = new ConcreteVisitorB();
        collection.accept(visitorB);

        System.out.println("------------------------------------");
        System.out.println("ConcreteVisitorC handle elements:");
        IVisitor visitorC = new ConcreteVisitorC();
        collection.accept(visitorC);

    }

}
