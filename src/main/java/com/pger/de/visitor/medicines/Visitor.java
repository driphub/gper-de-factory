package com.pger.de.visitor.medicines;

import java.math.BigDecimal;

/**
 * 抽象访问者
 *
 */
public abstract class Visitor {
    protected String userName;

    public Visitor setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public abstract void visitor(MedicineA a);

    public abstract void visitor(MedicineB b);

    public abstract String getMsg(String operator, String name, BigDecimal price);

}
