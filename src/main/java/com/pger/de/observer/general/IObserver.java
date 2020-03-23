package com.pger.de.observer.general;

//抽象观察者 -- 观察者
public interface IObserver<E> {
    void update(E event);
}