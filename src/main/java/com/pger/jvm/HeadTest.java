package com.pger.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeadTest {

    static List<Person> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            list.add(new Person());
            Thread.sleep(1);
        }
    }
}
