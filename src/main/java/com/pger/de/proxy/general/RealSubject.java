package com.pger.de.proxy.general;

/**
 *
 */
public class RealSubject implements ISubject {
    @Override
    public void request() {
        System.out.println("real service is called.");
    }

}
