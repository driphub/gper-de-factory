package com.pger.de.iterator.general;

//抽象容器
public interface IAggregate<E> {
    boolean add(E element);

    boolean remove(E element);

    Iterator<E> iterator();
}