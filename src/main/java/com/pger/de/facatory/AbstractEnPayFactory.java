package com.pger.de.facatory;

/**
 * 国际支付抽象工厂
 *
 * @author s
 */
public abstract class AbstractEnPayFactory {

    /**
     * PayPal
     *
     * @return
     */
    protected abstract IEnPayFactory payPal();

    /**
     * ApplePay
     *
     * @return
     */
    protected abstract IEnPayFactory applePay();


}
