package com.pger.de.observer.gper.guava;

import com.google.common.eventbus.Subscribe;

public class GperTeacherImpl extends GperTeacher {

    public GperTeacherImpl(String userName) {
        super.setUserName(userName);
    }

    @Subscribe
    @Override
    public void publishQuestion(Question question) {
        System.out.printf(question.getUserName() + " 在咕泡社区" + "上提交了一个问题。\n");
        StringBuilder builder = new StringBuilder();
        builder.append(getUserName()).append(" 老师，您好！\n");
        builder.append("您收到了一个来自 ").append(question.getUserName());
        builder.append(" 的提问，希望您解答。问题内容如下：");
        builder.append(question.getContent() + "\n");
        System.out.printf(builder.toString());
    }

}
