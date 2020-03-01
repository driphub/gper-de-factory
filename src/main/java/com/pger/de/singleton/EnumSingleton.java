package com.pger.de.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public enum EnumSingleton {
    INSTANCE;
    
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
    
    public static void main(String[] args) {
        try {
            EnumSingleton s1 = null;
            EnumSingleton s2 = EnumSingleton.getInstance();
            s2.setData(new Object());
            
            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj"); 
            ObjectOutputStream oos = new ObjectOutputStream(fos); 
            oos.writeObject(s2);
            oos.flush();
            oos.close();
            
            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (EnumSingleton) ois.readObject();
            ois.close();
            
            System.out.println(s1.getData()); 
            System.out.println(s2.getData()); 
            System.out.println(s1.getData() == s2.getData());
            
            // 枚举破坏单例
            Class clazz = EnumSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            EnumSingleton enumSingleton = (EnumSingleton) c.newInstance("Tom", 666);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
