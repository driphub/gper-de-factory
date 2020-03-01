package com.pger.de.singleton;


public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {

    }

    private static final ThreadLocal<ThreadLocalSingleton> THREAD_LOCAL = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance() {
        return THREAD_LOCAL.get();
    }

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        Thread t1 = new Thread(new LazySimpleSingleton.ExectorThread());
        Thread t2 = new Thread(new LazySimpleSingleton.ExectorThread());
        t1.start();
        t2.start();
        System.out.println("End");
    }

}
