package com.pger.de.observer.gper;

import java.util.Observable;

/**
 * 被观察者
 */
public class Gper extends Observable {
    private String name = "GPer生态圈";
    private static final Gper gper = new Gper();

    public String getName() {
        return name;
    }

    private Gper() {

    }

    public static Gper getInstance() {
        return gper;
    }

    public void publishQuestion(Question question) {
        System.out.printf(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }

}
