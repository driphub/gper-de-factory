package com.pger.de.facatory;

public class EnPayFactroy extends AbstractEnPayFactory {

    public IEnPayFactory payPal() {
        return new EnPayPal();
    }

    public IEnPayFactory applePay() {
        return new EnApplePay();
    }

}
