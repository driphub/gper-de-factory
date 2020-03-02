package com.pger.de.prototype;

import java.util.ArrayList;
import java.util.List;

public class ConcreteJsonPrototypeTest {

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
        ConcreteJsonPrototype cloneType = prototype.jsonDeepClone();
        cloneType.getHobbies().add("技术控");

        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.err.println(prototype == cloneType);
    }


}
