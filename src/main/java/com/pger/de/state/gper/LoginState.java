package com.pger.de.state.gper;

public class LoginState extends UserState {
    @Override
    public void favorite() {
        System.out.printf("收藏成功！");
    }

    @Override
    public void comment(String comment) {
        System.out.printf(comment);
    }

}
