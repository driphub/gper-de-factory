package com.pger.de.observer.gper;

public class Test {
    public static void main(String[] args) {
        Gper gper = Gper.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher jack = new Teacher("Jack");

        gper.addObserver(tom);
        gper.addObserver(jack);

        //用户行为
        Question question = new Question();
        question.setUserName("张三");
        question.setContent("观察者模式适用于哪些场景？");

        gper.publishQuestion(question);
    }
}
