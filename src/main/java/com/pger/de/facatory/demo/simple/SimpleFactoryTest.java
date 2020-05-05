package com.pger.de.facatory.demo.simple;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        // 1
        //ICourse course = new JavaCourse();
        //course.record();

        // 2
        CourseFactory factory = new CourseFactory();
        //ICourse course = factory.create("python");
        //course.record();

        // 3
        String javaCourceName = "com.pger.de.facatory.demo.simple.JavaCourse";
        //ICourse course = factory.create2(javaCourceName);
        //course.record();

        // 4
        ICourse course = factory.create3(PythonCourse.class);
        course.record();
    }
}
