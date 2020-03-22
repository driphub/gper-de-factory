package com.pger.de.interpreter.calculate;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println("result: " + new GPCalculator("10 + 30").calculate());
//        System.out.println("result: " + new GPCalculator("10 + 30 - 20").calculate());
//        System.out.println("result: " + new GPCalculator("100 * 2 + 400 * 2 + 66").calculate());
        System.out.printf("result: " + new GPCalculator("100 * 2 + 400 * 2 + 66 + ( 100 / 5 )").calculate());
    }

}
