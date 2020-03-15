package com.pger.de.strategy.userlogin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum  UserLoginStrategy {

    INSTANCE;

    private static Map<String, AbstractUserLogin> loginMap = new ConcurrentHashMap<String, AbstractUserLogin>();
    private static boolean isInit = false;

    public static UserLoginStrategy getInstance() {
        if (!isInit) {
            loginMap.put(LoginTypeEnum.LOGIN_WEIBO.getCode(), new WeboLogin());
            loginMap.put(LoginTypeEnum.LOGIN_ALI.getCode(), new AliLogin());
            loginMap.put(LoginTypeEnum.LOGIN_WECHAT.getCode(), new WechatLogin());
            loginMap.put(LoginTypeEnum.LOGIN_DEFAULT.getCode(), new WechatLogin());

            isInit = true;
        }
        return INSTANCE;
    }

    public AbstractUserLogin getLoginImpl(String loginType) {
        if (!loginMap.containsKey(loginType)) {
            return loginMap.get(LoginTypeEnum.LOGIN_DEFAULT.getCode());
        }
        return loginMap.get(loginType);
    }

}
