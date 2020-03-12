package com.pger.de.template.course;

public class CompositeJavaCourse {

    private AbastractCourse course;

    private boolean needCheckHomework = false;

    public void setNeedCheckHomework(boolean needCheckHomework) {
        this.needCheckHomework = needCheckHomework;
    }

    public CompositeJavaCourse() {
        course = new AbastractCourse() {
            @Override
            protected boolean needCheckHomework() {
                return CompositeJavaCourse.this.needCheckHomework;
            }

            @Override
            protected void checkHomework() {
                System.out.printf("检查java作业");
            }
        };
    }

    public void createJavaCourse() {
        course.createCourse();
    }

}
