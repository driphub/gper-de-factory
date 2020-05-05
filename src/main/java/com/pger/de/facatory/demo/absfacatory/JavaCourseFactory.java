package com.pger.de.facatory.demo.absfacatory;

/**
 */
public class JavaCourseFactory extends CourseFactory {

    @Override
    public INote createNote() {
        super.init();
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }

}
