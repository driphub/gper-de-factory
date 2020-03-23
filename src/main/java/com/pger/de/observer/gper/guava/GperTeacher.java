package com.pger.de.observer.gper.guava;

public abstract class GperTeacher {

    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void publishQuestion(Question question) { }

}
