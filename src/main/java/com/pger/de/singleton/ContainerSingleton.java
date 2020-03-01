package com.pger.de.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>(16);
    private static final ThreadLocal threadLocal = new ThreadLocal();

    // 非线程安全
    public static Object getBean(String clazzName) {
        synchronized (ioc) {
            if (!ioc.containsKey(clazzName)) {
                Object object = null;
                try {
                    object = Class.forName(clazzName).newInstance();
                    ioc.put(clazzName, object);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return object;
            } else {
                return ioc.get(clazzName);
            }
        }
    }

    // 使用ThreadLocal保证线程安全，性能也得到优化
    public static Object getTLInstance(String className) {
        ioc = getContext();
        if (!ioc.containsKey(className)) {
            Object object = null;
            try {
                object = Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ioc.put(className, object);
            threadLocal.set(ioc);
            return object;
        }
        return ioc.get(className);
    }

    private static Map<String, Object> getContext() {
        System.err.println(ioc);
        Map<String, Object> map = (Map<String, Object>) threadLocal.get();
        if (map == null) {
            map = ioc;
        }
        return map;
    }

    // 改造后，双重检查锁
    public static Object getInstance(String className) {
        if (!ioc.containsKey(className)) {
            try {
                Class clazz = Class.forName(className);
                synchronized (clazz) {
                    if (!ioc.containsKey(className)) {
                        Object object = clazz.newInstance();
                        ioc.put(className, object);
                        return object;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ioc.get(className);
    }

    public static class ContainerExectorThread implements Runnable {
        @Override
        public void run() {
            Object instance = ContainerSingleton.getInstance("com.tps.monitorclient.test.User");
            System.err.println(Thread.currentThread().getName() + ":" + instance);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ContainerExectorThread());
        Thread t2 = new Thread(new ContainerExectorThread());
        Thread t3 = new Thread(new ContainerExectorThread());
        t1.start();
        t2.start();
        t3.start();

        System.err.println("end program");
    }
}
