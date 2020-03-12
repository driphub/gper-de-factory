package com.pger.de.classloader;


import java.io.InputStream;

public class DifferentClassTest {
    public static void main(String[] args) {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] bt = new byte[is.available()];
                    is.read(bt);
                    return defineClass(name, bt, 0, bt.length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return super.loadClass(name);
            }
        };

        try {
            Object obj = loader.loadClass("com.pger.de.classloader.DifferentClassTest").newInstance();
            System.out.printf("----->" + obj.getClass());
            boolean rs = obj instanceof DifferentClassTest;
            System.out.printf("\n>>>>>>>>" + rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
