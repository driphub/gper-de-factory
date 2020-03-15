package com.pger.de.strategy.userlogin;

import org.springframework.util.StringUtils;

public class WeboLoginValidate extends Handler {
    @Override
    public void doHandler(String userId) {
        System.out.printf("微博登录成功，账号：" + userId + "\n");
    }

}