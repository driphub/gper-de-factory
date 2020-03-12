package com.pger.de.template.course;

public class CompositePythonCourse {

    private AbastractCourse course;

    public CompositePythonCourse() {
        course = new AbastractCourse() {
            @Override
            protected void checkHomework() {
                System.out.printf("检查Python");
            }
        };
    }

    public void createPythonCourse() {
        course.createCourse();
    }

}
