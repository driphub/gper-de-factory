package com.pger.de.state.gper;

public class UnLoginState extends UserState {
    @Override
    public void favorite() {
        this.switchToLogin();
        this.context.getState().favorite();
    }

    @Override
    public void comment(String comment) {
        this.switchToLogin();
        this.context.getState().comment(comment);
    }

    private void switchToLogin(){
        System.out.printf("跳转到登录页面！");
        this.context.setState(this.context.STATE_LOGIN);
    }
}
