package com.pger.de.prototype;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConcreteJsonPrototype {

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
    public String toString() {
        return "ConcreteJsonPrototype [age=" + age + ", name=" + name + ", hobbies=" + hobbies + "]";
    }


    /**
     * 原理：
     * 1、利用反射获取类的各个属性
     *  BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
     *  PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
     * 2、遍历属性，然后获取set feild属性，以及属性值
     * 3、通过method.invoke(obj, feild)
     *
     *
     *  传入json对象
     * @return
     */
    public ConcreteJsonPrototype jsonDeppClone() {
        JSON jsonObj = (JSON) JSON.toJSON(this);
        ConcreteJsonPrototype prototype = JSONObject.toJavaObject(jsonObj, ConcreteJsonPrototype.class);
        return prototype;
    }

    public static void main(String[] args) {
        // 创建原型对象
        ConcreteJsonPrototype prototype = new ConcreteJsonPrototype();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> list = new ArrayList<String>();
        list.add("书法");
        list.add("美术");
        prototype.setHobbies(list);

        // 拷贝原型对象
        ConcreteJsonPrototype cloneType = prototype.jsonDeppClone();
        cloneType.getHobbies().add("技术控");

        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.err.println(prototype == cloneType);
    }

}
