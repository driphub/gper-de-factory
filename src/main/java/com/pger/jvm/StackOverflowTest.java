package com.pger.jvm;

public class StackOverflowTest {

    public static long count = 0;

    private static void method(long i) {
        System.out.printf("------->> count = " + count++ + "\n");
        method(i);
    }

    public static void main(String[] args) {
        method(1);
    }

}