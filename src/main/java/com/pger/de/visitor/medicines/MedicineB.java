package com.pger.de.visitor.medicines;

import java.math.BigDecimal;

/**
 * 具体药品元素B
 */
public class MedicineB extends Medicine {

    public MedicineB(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    public String operationB() {
        return "操作处方：";
    }

}
