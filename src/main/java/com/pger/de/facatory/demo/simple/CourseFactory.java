package com.pger.de.facatory.demo.simple;

public class CourseFactory {

    /**
     * 第一种 简单工厂模式
     *
     * @param name
     * @return
     */
    public ICourse create(String name) {
        if ("java".equals(name)) {
            return new JavaCourse();
        } if ("python".equals(name)) {
            return new PythonCourse();
        } else {
            return null;
        }
    }

    public ICourse create2(String className) {
        try {
            if (!(className == null || "".equals(className))) {
                return (ICourse) Class.forName(className).newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ICourse create3(Class<? extends ICourse> clazz) {
        try {
            if (clazz !=null) {
                return clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
