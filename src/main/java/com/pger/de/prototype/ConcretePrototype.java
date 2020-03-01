package com.pger.de.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConcretePrototype implements Cloneable, Serializable {

    private int age;
    private String name;
    private List<String> hobbies;
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    protected ConcretePrototype clone() throws CloneNotSupportedException {
        try {
            return (ConcretePrototype) super.clone();
        } catch (Exception e) {
            return null;
        }
    }
    
    public ConcretePrototype deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
            
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (ConcretePrototype) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "ConcretePrototype [age=" + age + ", name=" + name + ", hobbies=" + hobbies + "]";
    }

    public static void main(String[] args) throws Exception {
        // 创建原型对象
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> list = new ArrayList<String>();
        list.add("书法");
        list.add("美术");
        prototype.setHobbies(list);
        
        // 拷贝原型对象
        ConcretePrototype cloneType = prototype.deepClone();
        cloneType.getHobbies().add("技术控");

        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.err.println(prototype == cloneType);
        
        System.err.println("原型对象爱好：" + prototype.getHobbies());
        System.err.println("克隆对象爱好：" + cloneType.getHobbies());
        System.err.println(prototype.getHobbies() == cloneType.getHobbies());
    }

}
