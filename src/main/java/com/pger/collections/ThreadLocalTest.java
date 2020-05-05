package com.pger.collections;

public class ThreadLocalTest {
    private static int num = 0;
    private static ThreadLocal<Integer> numLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    private static ThreadLocal<Index> indexLocal = new ThreadLocal<Index>() {
        @Override
        protected Index initialValue() {
            return index;
        }
    };

    static Index index = new Index();
    static class Index {
        private int num;
        public void incr() {
            num ++;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
//                num += 5; // 未使用线程副本
//                int num = numLocal.get().intValue() + 5; // 使用线程副本
                Index index = indexLocal.get();
                index.incr();
                System.out.printf("\n" + Thread.currentThread().getName() + "----> " + index.num);
            }, "Thread-" + i).start();
        }
    }
}
