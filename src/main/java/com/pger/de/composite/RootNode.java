package com.pger.de.composite;

/**
 * 抽象根节点
 */
public abstract class RootNode {

    protected String name;

    public RootNode(String name) {
        this.name = name;
    }

    public abstract void show();

}