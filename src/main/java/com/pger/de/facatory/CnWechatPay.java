package com.pger.de.facatory;

public class CnWechatPay implements ICnPayFactory {
    public void payment() {
        System.out.println("--------> 国内支付：WechatPay");
    }
}
