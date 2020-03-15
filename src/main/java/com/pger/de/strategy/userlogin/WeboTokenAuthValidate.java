package com.pger.de.strategy.userlogin;

import org.springframework.util.StringUtils;

public class WeboTokenAuthValidate extends Handler {
    @Override
    public void doHandler(String userId) {
        if (StringUtils.isEmpty(userId)) {
            System.out.printf("微博授权失败\n");
        }
        System.out.printf("微博授权成功\n");
        if(null != next) {
            next.doHandler(userId);
        }
    }

}
