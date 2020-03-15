package com.pger.de.strategy.userlogin;

import org.springframework.util.StringUtils;

public class WeChatLoginValidate extends Handler {
    @Override
    public void doHandler(String userId) {
        if (StringUtils.isEmpty(userId)) {
            System.out.printf("微信授权失败\n");
        }
        System.out.printf("微博授权并登录成功，账号：" + userId + "\n");
    }
}
