package com.pger.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorsTest {
    // 创建的线程，如果空闲60秒，会被自动回收

    ExecutorService executorService1 = Executors.newSingleThreadExecutor(); // 构建只有一个线程的线程池
    ExecutorService executorService2 = Executors.newFixedThreadPool(10);// 返回一个固定线程数量的线程池
    ExecutorService executorService3 = Executors.newCachedThreadPool();// 创建一个可以根据实际情况创建的线程池，不限制最大线程数量，最大线程数：Integer.MAX_VALUE
    ExecutorService executorService4 = Executors.newScheduledThreadPool(10);// 通过延迟执行的，可以实现任务调度

    // corePoolSize 核心线程数
    // maximumPoolSize 最大线程数
    // keepAliveTime 非核心线程数的空余线程存活时间
    // timeunit 存活单位
    // LinkedBlockingQueue<Runnable> workQueue 当前线程超过核心线程数，将多余的线程加入线程阻塞队列排队
    // ThreadFactory 线程工厂
    // RejectedExecutionHandler 拒绝策略：

    /**
    原理：1、首先主线程调用executor方法，executor方法会构建corePoolSize和maximumPoolSize、阻塞队列
    2、当主线程通过executor方法加一个任务去执行的时候，如果当前的核心线程数定义了4个，但是现在线程池里面线程不到4个，可以创建一个核心线程数，会停留在线程池中，一直存活下去，不会被回收
    如果当前核心线程数超过定义的核心线程数时，会把多余的线程加入到阻塞队列中，通过核心线程数不断的从队列中取数据take，如果队列里面添加失败，意味着队列满了
    3、创建一个非核心线程数，如果当前最大线程数是10个，核心线程数是2个，那么允许创建剩下的8个线程，如果8个线程满了，就无法创建，则走拒绝策略

    核心线程数和非核心线程数区别：
    举例：编制内员工（核心），外包员工（非核心）

    4、线程运行：线程池中通过worker执行的，传递个任务，实际上是将任务丢给worker去执行,运行task的run 方法

     非核心线程数会被回收、


     **/

    private volatile static int aaNum = 1;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.printf("aaaaa = " + aaNum);
//        lock.lock();

        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }
            }
        }, "Time_Waiting_Thread").start();

        new Thread(() -> {
            while (true) {
                synchronized (ExecutorsTest.class) {
                    try {
                        ExecutorsTest.class.wait();
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }
        }, "Waiting_Thread").start();

        new Thread(new Blocked(), "Blocked01_Thread").start();
        new Thread(new Blocked(), "Blocked02_Thread").start();

    }

    static class Blocked extends Thread {
        @Override
        public void run() {
            synchronized (ExecutorsTest.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }
        }
    }

}
