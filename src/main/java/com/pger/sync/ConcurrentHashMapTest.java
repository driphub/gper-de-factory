package com.pger.sync;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        try {
//            int i = ThreadLocalRandom.getProbe();
            int i = Integer.numberOfLeadingZeros(16) | (1 << (16 - 1));
            System.out.printf("" + i);

            int cpun = Runtime.getRuntime().availableProcessors();
            System.out.printf("\n" + cpun);
        } catch (Exception e) {

        }
        int a = -1 << 29;
        System.out.printf("\n----" + a);

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.printf("--------> " + classLoader);
    }
}
