package com.pger.de.singleton;

/**
 * 懒汉式单例模式
 * 优点：被外部调用时内部类才会加载
 * 缺点：非线程安全
 * 
 */
public class LazySimpleSingleton {
    
    private volatile static LazySimpleSingleton simpleSingleton;
    private LazySimpleSingleton() {
        
    }
    
    // 非线程安全模式
    public static LazySimpleSingleton getInstance() {
        if (simpleSingleton == null) {
            simpleSingleton = new LazySimpleSingleton();
        }
        return simpleSingleton;
    }
    
    /**
     * 线程安全，但存在性能开销，加锁时在线程数量较多的情况下，如果CPU分配压力上升，会导致大多线程阻塞，性能下降
     * 
     */
    public static LazySimpleSingleton getInstance2() {
        synchronized(LazySimpleSingleton.class) {
            if (simpleSingleton == null) {
                simpleSingleton = new LazySimpleSingleton();
            }
        }
        return simpleSingleton;
    }
    
    // 双重检查锁模式
    // 分配内存对象，初始化对象，lazy指向刚分配的内存地址，初次访问对象
    // 优点：线程安全
    // 缺点：代码繁琐，不够优雅、性能开销
    public static LazySimpleSingleton getInstance3() {
        if (simpleSingleton == null) {
            synchronized(LazySimpleSingleton.class) {
                if (simpleSingleton == null) {
                    simpleSingleton = new LazySimpleSingleton();
                }
            }
        }
        return simpleSingleton;
    }
    
    
    public static class ExectorThread implements Runnable  {
        public void run() {
            LazySimpleSingleton lazySimpleSingleton = LazySimpleSingleton.getInstance();
            System.err.println(Thread.currentThread().getName() + ":" + lazySimpleSingleton);
        }
    }
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();
        
        System.err.println("end");
    }
}
