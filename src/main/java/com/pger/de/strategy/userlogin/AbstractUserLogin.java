package com.pger.de.strategy.userlogin;


/**
 *
 * 重构各种渠道登录方式
 *
 */
public abstract class AbstractUserLogin {

    public abstract String loginType();

    public abstract String getName();

    protected abstract void login(String userId);

}
