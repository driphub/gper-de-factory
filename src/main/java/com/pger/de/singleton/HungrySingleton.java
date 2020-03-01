package com.pger.de.singleton;

/**
 * 恶汉式单例模式
 * 优点：无须加锁，线程安全，执行效率高，用户体验好
 * 缺点：类加载的时候初始化对象，不管是否使用都会占用内存空间，浪费内存空间
 * 适用单例较少的系统
 * 
 * Spring的IOC中的ApplicationContext就是一个典型的饿汉式单例模式
 * 
 */
public class HungrySingleton {
    
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {
        
    }
    
    public static HungrySingleton getInstance() {
        return instance;
    }
}
