package com.pger.sync;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环屏障，循环栅栏
 * 使一组线程达到一个同步点之前阻塞
 */
public class CycliBarrierTest extends Thread {

    @Override
    public void run() {
        System.out.printf("开始进行数据分析......\n");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CycliBarrierTest());
        new Thread(new DataImportThread("file1", cyclicBarrier)).start();
        new Thread(new DataImportThread("file2", cyclicBarrier)).start();
        new Thread(new DataImportThread("file3", cyclicBarrier)).start();

    }

    static class DataImportThread extends  Thread {
        private String path;
        private CyclicBarrier cyclicBarrier;

        public DataImportThread(String path, CyclicBarrier cyclicBarrier) {
            this.path = path;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.printf("导入 " + path + " 数据\n");

                int i = cyclicBarrier.await();

                System.out.printf("-----> 第 " + i + " 个线程\n");
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {

            }
        }
    }


}
