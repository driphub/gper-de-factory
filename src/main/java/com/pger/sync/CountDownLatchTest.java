package com.pger.sync;

import java.util.concurrent.CountDownLatch;


/**
 *
 * 1.缓存预热
 * 2.计数器作用
 *
 */
public class CountDownLatchTest {

//    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(3);
//
//        new Thread(() -> {
//            System.out.printf("ThreadA --> ");
//            countDownLatch.countDown();
//        },"ThreadA").start();
//
//        new Thread(() -> {
//            System.out.printf("\nThreadB --> ");
//            countDownLatch.countDown();
//
//        },"ThreadB").start();
//
//        new Thread(() -> {
//            System.out.printf("\nThreadC --> ");
//            countDownLatch.countDown();
//
//        },"ThreadC").start();
//
//        System.out.printf("\n countDownLatch1 = " + countDownLatch.getCount());
//        countDownLatch.await();
//        System.out.printf("\n countDownLatch2 = " + countDownLatch.getCount());
//    }

    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new ThreadA().start();
        }
        // 倒计时到0
        countDownLatch.countDown();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                countDownLatch.await();// 阻塞 3个线程
            } catch (Exception e) {
                e.printStackTrace();
            }
            // TODO
            System.out.printf("\nThreadName = " + Thread.currentThread().getName());
        }
    }


}
