package com.pger.sync;


import java.util.concurrent.Semaphore;

/**
 * 版本的信号量实现
 *
 * 限流
 * 基于AQS实现
 *
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Car(i, semaphore).start();
        }
    }

    static class Car extends  Thread {
        private int num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();// 获得一个令牌 ，如果拿不到令牌，则阻塞
                System.out.printf("-----> 第 " + num + " 抢占一个车位\n");

                Thread.sleep(2000);

                System.out.printf("----> 第 " + num + " 车开走\n");

                semaphore.release();
            } catch (Exception e) {

            }
        }
    }
}
