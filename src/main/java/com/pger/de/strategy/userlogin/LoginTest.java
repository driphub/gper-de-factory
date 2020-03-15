package com.pger.de.strategy.userlogin;

public class LoginTest {
    public static void main(String[] args) {
        UserLoginService service = new UserLoginService();
        service.login(LoginTypeEnum.LOGIN_ALI.getCode(), "abcefghijk888");
    }
}
