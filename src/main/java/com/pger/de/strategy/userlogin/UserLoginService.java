package com.pger.de.strategy.userlogin;

public class UserLoginService {

    public void login(String loginType, String userId) {
        AbstractUserLogin userLogin = UserLoginStrategy.getInstance().getLoginImpl(loginType);
        System.out.printf("登录方式：" + userLogin.getName() + "\n");
        System.out.printf("=================================\n");
        userLogin.login(userId);
    }

}
