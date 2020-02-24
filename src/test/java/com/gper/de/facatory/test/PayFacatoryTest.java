package com.gper.de.facatory.test;

import com.pger.de.facatory.CnPayFacatory;
import org.junit.Test;

public class PayFacatoryTest {

    @Test
    public void createPayTest() {
        CnPayFacatory cnPayFacatory = new CnPayFacatory();
        cnPayFacatory.alipay().payment();
    }

}
