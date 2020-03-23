package com.pger.de.observer.guava;

import com.google.common.eventbus.Subscribe;

public class PojoEvent {
    @Subscribe
    public void observer(Pojo pojo) {
        System.out.println("执行PojoEvent方法，传参为：" + pojo);
    }
}
