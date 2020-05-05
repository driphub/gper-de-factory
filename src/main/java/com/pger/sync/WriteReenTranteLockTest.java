package com.pger.sync;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁操作
 */
public class WriteReenTranteLockTest {

    private static final Map<String, String> m = new HashMap<>();
    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static final Lock r = rwl.readLock();
    private static final Lock w = rwl.writeLock();

    public static String get(String key) {
        r.lock();
        try {
            System.out.printf(" 读取锁锁定 ");
            return m.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            r.unlock();
        }
        return null;
    }

    public static String put(String key, String value) {
        w.lock();
        try {
            System.out.printf(" 写锁锁定 ");
            return m.put(key, value);
        } catch (Exception e) {

        } finally {
            w.unlock();
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
