package com.pger.sync;

public class LockTest {

    private static class DLockA extends Thread {
        @Override
        public void run() {
            try {
                System.out.printf("LockA running \n");
                while (true) {
                    synchronized (Client.obj1) {
                        System.out.printf("LockA locked obj1 \n");
                        Thread.sleep(100);
                        System.out.printf("LockA trying to lock obj2... \n");
                        synchronized (Client.obj2) {
                            System.out.printf("LockA locked obj2 \n");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class DLockB extends Thread {
        @Override
        public void run() {
            try {
                System.out.printf("LockB running \n");
                while (true) {
                    synchronized (Client.obj2) {
                        System.out.printf("LockB locked obj2 \n");
                        System.out.println("LockB trying to lock obj1... \n");
                        synchronized (Client.obj1) {
                            System.out.println("LockB locked obj1 \n");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class Client {
        public static final String obj1 = "obj1";
        public static final String obj2 = "obj2";

        public static void main(String[] args) {
            new DLockA().start();
            new DLockB().start();
        }
    }

    public synchronized void method1(LockTest clazz) {
        System.out.printf("LockTest method1 \n");
        clazz.method2();
        System.out.println("LockTest method1 out");
    }

    public synchronized void method2() {
        System.out.println("LockTest method2");
    }

    private static class TestLock extends Thread {
        private LockTest class1;
        private LockTest class2;

        public TestLock(LockTest class1, LockTest class2) {
            this.class1 = class1;
            this.class2 = class2;
        }

        @Override
        public void run() {
            class1.method1(class2);
        }
    }

    public static void main(String[] args) {
        LockTest a = new LockTest();
        LockTest b = new LockTest();

        new TestLock(a, b).start();
        new TestLock(b, a).start();
    }


}
