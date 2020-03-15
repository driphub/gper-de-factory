package com.pger.de.strategy.userlogin;

public enum LoginTypeEnum {

    LOGIN_ALI("ALI_LOGIN", "支付宝登录"),
    LOGIN_WECHAT("WECHAT_LOIGN", "微信登录"),
    LOGIN_WEIBO("WEIBO_LOGIN", "微博登录"),
    LOGIN_DEFAULT("WECHAT_LOIGN", "微信登录");

    private String code;
    private String name;

    private LoginTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
