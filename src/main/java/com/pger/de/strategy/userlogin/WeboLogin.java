package com.pger.de.strategy.userlogin;


public class WeboLogin extends AbstractUserLogin {
    @Override
    public String loginType() {
        return LoginTypeEnum.LOGIN_WEIBO.getCode();
    }

    @Override
    public String getName() {
        return LoginTypeEnum.LOGIN_WEIBO.getName();
    }

    @Override
    protected void login(String userId) {
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler())
            .addHandler(new WeboTokenAuthValidate())
            .addHandler(new WeboLoginValidate());
        builder.build().doHandler(userId);
    }
}
