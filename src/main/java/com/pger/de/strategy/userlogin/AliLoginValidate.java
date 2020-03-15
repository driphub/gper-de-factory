package com.pger.de.strategy.userlogin;

public class AliLoginValidate extends Handler {
    @Override
    public void doHandler(String userId) {
        System.out.printf("支付宝登录成功，账号：" + userId + "\n");
    }
}
