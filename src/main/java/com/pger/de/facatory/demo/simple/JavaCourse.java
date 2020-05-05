package com.pger.de.facatory.demo.simple;

public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.printf("录制Java课程");
    }
}