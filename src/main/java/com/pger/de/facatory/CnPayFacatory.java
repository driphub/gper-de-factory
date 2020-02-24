package com.pger.de.facatory;

public class CnPayFacatory extends AbstractCnPayFacatory {
    public ICnPayFactory alipay() {
        return new CnAliPay();
    }

    public ICnPayFactory wechatPay() {
        return new CnWechatPay();
    }

    public ICnPayFactory unionPay() {
        return new CnUnionPay();
    }


}
