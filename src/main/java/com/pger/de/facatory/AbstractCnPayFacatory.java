package com.pger.de.facatory;

public abstract class AbstractCnPayFacatory {

    protected abstract ICnPayFactory alipay();

    protected abstract ICnPayFactory wechatPay();

    protected abstract ICnPayFactory unionPay();

}
