package com.pger.de.visitor.medicines;

import java.math.BigDecimal;

/**
 * 具体访问者：药房工作人员
 */
public class WorkerOfPharmacy extends Visitor {
    @Override
    public void visitor(MedicineA a) {
        System.out.printf(getMsg(a.operationA(), a.getName(), a.getPrice()));
    }

    @Override
    public void visitor(MedicineB b) {
        System.out.printf(getMsg(b.operationB(), b.getName(), b.getPrice()));
    }

    @Override
    public String getMsg(String operator, String name, BigDecimal price) {
        StringBuilder builder = new StringBuilder();
        builder.append(operator).append(" 药房工作人员：");
        builder.append(userName).append("拿药 [");
        builder.append(name).append("]，价格为：");
        builder.append(price);

        return builder.toString();

    }
}
