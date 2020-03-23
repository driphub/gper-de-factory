package com.pger.de.observer.guava;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        PojoEvent pojoEvent = new PojoEvent();
        VoEvent voEvent = new VoEvent();
        eventBus.register(pojoEvent);
        eventBus.register(voEvent);

        eventBus.post(new Vo("Tom"));

    }
}
