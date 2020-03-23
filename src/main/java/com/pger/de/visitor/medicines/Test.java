package com.pger.de.visitor.medicines;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        Presciption presciption = new Presciption();

        Medicine a = new MedicineA("药品A", new BigDecimal("20"));
        Medicine b = new MedicineB("药品B", new BigDecimal("30"));

        presciption.addElement(a);
        presciption.addElement(b);

        PriceMarker marker = (PriceMarker) new PriceMarker().setUserName("小王");
        WorkerOfPharmacy worker = (WorkerOfPharmacy) new WorkerOfPharmacy().setUserName("小李");

        presciption.accept(marker);

        System.out.printf("============= 分割线  ==============\n");

        presciption.accept(worker);

    }
}
