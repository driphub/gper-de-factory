package com.pger.de.strategy.userlogin;

public class AliLogin extends AbstractUserLogin {
    @Override
    public String loginType() {
        return LoginTypeEnum.LOGIN_ALI.getCode();
    }

    @Override
    public String getName() {
        return LoginTypeEnum.LOGIN_ALI.getName();
    }

    @Override
    protected void login(String userId) {
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler())
                .addHandler(new AliAuthValidate())
                .addHandler(new AliLoginValidate());
        builder.build().doHandler(userId);
    }

}
