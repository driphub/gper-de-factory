package com.pger.de.strategy.userlogin;


import org.springframework.util.StringUtils;

public class ValidateHandler extends Handler {
    public void doHandler(String userId) {
        if(StringUtils.isEmpty(userId)){
            System.out.println("账号不存在或不能为空");
            return;
        }
        System.out.println("账号存在，可以往下执行");
        if(null != next) {
            next.doHandler(userId);
        }
    }

}
