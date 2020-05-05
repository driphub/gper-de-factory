package com.pger.collections;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


public class HashMapTest {

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static final int getHashCode(int n, int hash) {
        return (n - 1) & hash;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "jack");
        map.put("2", "tom");
        System.out.printf("\n"+ "------>>  map = " + map + ", hashCode = " + map.hashCode() + ", mo = " + hash("1"));

        System.out.printf("--" + getHashCode(16, hash("10")));
    }

    private String toLowerFirstCase(String str) {
        if ("".equals(str) || str == null) {
            return null;
        }
        char[] c = str.toCharArray();
        c[0] += 32;
        return String.valueOf(c);
    }

}
