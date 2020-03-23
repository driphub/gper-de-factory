package com.pger.de.visitor.medicines;


import java.math.BigDecimal;

/**
 * 具体访问者：划价员
 */
public class PriceMarker extends Visitor {

    @Override
    public void visitor(MedicineA a) {
        System.out.println(getMsg(a.operationA(), a.getName(), a.getPrice()));
    }

    @Override
    public void visitor(MedicineB b) {
        System.out.println(getMsg(b.operationB(), b.getName(), b.getPrice()));
    }

    @Override
    public String getMsg(String operator, String name, BigDecimal price) {
        StringBuilder builder = new StringBuilder();
        builder.append(operator).append(" 划价员：");
        builder.append(userName).append("为 ");
        builder.append(name).append(" 药品，划价：");
        builder.append(price);

        return builder.toString();
    }
}
