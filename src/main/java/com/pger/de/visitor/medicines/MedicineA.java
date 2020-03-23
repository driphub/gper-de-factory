package com.pger.de.visitor.medicines;

import java.math.BigDecimal;

/**
 * 具体药品元素A
 */
public class MedicineA extends Medicine {

    public MedicineA(String name, BigDecimal pirce) {
        super(name, pirce);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    public String operationA() {
        return "操作处方：";
    }

}
