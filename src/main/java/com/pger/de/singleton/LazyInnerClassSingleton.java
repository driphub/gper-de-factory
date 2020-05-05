package com.pger.de.singleton;

import java.lang.reflect.Constructor;

/**
 * 内部静态类
 * 优点：兼容饿汉式单例模式的内存浪费问题和 synchronized 的性能问题，线程安全
 * 缺点：
 * 
 * 反射机制破坏单例
 * 
 * 
 */
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {
        if (LazyHandler.INSTANCE !=null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }
    
    private static class LazyHandler {
        private static final LazyInnerClassSingleton INSTANCE = new LazyInnerClassSingleton();
    }
    
    public static LazyInnerClassSingleton getInstance() {
        return LazyHandler.INSTANCE;
    }
    
    public static void main(String[] args) {
        try {
            Class<?> clazz = LazyInnerClassSingleton.class;
            // 通过反射获取私有的构造方法
            Constructor constructor = clazz.getDeclaredConstructor(null);
            // 强制访问
            constructor.setAccessible(true);
            
            Object o1 = constructor.newInstance();
            
            Object o2 = constructor.newInstance();
            
            System.err.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
