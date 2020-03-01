package com.pger.de.singleton;

/**
 * 饿汉式静态单例模式
 * 
 */
public class HungryStaticSingleton {
    
    private static HungryStaticSingleton singleton;
    private HungryStaticSingleton() {
        
    }
    
    static {
        singleton = new HungryStaticSingleton();
    }
    
    public static HungryStaticSingleton getInstance() {
        return singleton;
    }
    
}
