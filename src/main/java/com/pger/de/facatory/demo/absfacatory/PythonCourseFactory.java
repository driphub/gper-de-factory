package com.pger.de.facatory.demo.absfacatory;

/**
 * Created by Tom.
 */
public class PythonCourseFactory extends CourseFactory {

    @Override
    public INote createNote() {
        super.init();
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
