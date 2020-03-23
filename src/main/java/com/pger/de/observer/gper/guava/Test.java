package com.pger.de.observer.gper.guava;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        GperTeacher tom = new GperTeacherImpl("Tom");
        GperTeacher mic = new GperTeacherImpl("Mic");
        eventBus.register(tom);
        eventBus.register(mic);

        Question question = new Question().setUserName("张三").setContent("观察者模式适用于哪些场景");
        eventBus.post(question);
    }
}
