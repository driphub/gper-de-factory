package com.pger.de.visitor.medicines;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构：处方
 */
public class Presciption {
    List<Medicine> elementList = new ArrayList<Medicine>();

    public void addElement(Medicine medicine) {
        elementList.add(medicine);
    }

    public void accept(Visitor visitor) {
        for (Medicine medicine : this.elementList) {
            medicine.accept(visitor);
        }
    }

}
