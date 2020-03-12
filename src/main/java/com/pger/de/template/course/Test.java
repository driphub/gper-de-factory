package com.pger.de.template.course;

public class Test {
    public static void main(String[] args) {
        System.out.printf("======== java架构师课程 ========");
//        JavaCourse java = new JavaCourse();
//        java.setNeedCheckHomework(false);
//        java.createCourse();

//        System.out.printf("======== Python 课程 =========");
//        PythonCourse python = new PythonCourse();
//        python.createCourse();


        CompositeJavaCourse java = new CompositeJavaCourse();
        java.createJavaCourse();

        System.out.printf("\n======== Python 课程 =========");
        CompositePythonCourse python = new CompositePythonCourse();
        python.createPythonCourse();
    }
}
