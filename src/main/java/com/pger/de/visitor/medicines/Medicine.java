package com.pger.de.visitor.medicines;

import java.math.BigDecimal;

/**
 * 抽象药品元素
 */
public abstract class Medicine {
    private String name;

    private BigDecimal price;

    public Medicine(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //接收访问者的访问
    public abstract void accept(Visitor visitor);

}
