package com.pger.de.strategy.userlogin;

public class WechatLogin extends AbstractUserLogin {
    @Override
    public String loginType() {
        return LoginTypeEnum.LOGIN_WECHAT.getCode();
    }

    @Override
    public String getName() {
        return LoginTypeEnum.LOGIN_WECHAT.getName();
    }

    @Override
    protected void login(String userId) {
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler())
                .addHandler(new WeChatLoginValidate());
        builder.build().doHandler(userId);
    }

}
