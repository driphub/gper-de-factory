package com.pger.de.composite;

/**
 * 抽象根节点
 */
public abstract class RootNode {

    protected String name;
    protected Integer lv;

    public RootNode(String name, Integer lv) {
        this.name = name;
        this.lv = lv;
    }

    public abstract void show();

}