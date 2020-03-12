package com.pger.de.delegate.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    private Map<String, IEmployee> employeeMap = new HashMap<String, IEmployee>();

    public Leader() {
        employeeMap.put("爬虫", new EmployeeA());
        employeeMap.put("海报图", new EmployeeB());
    }

    public void doing(String task) {
        if (!employeeMap.containsKey(task)) {
            System.out.printf("这个任务" + task + "超出我的能力范围");
            return ;
        }
        employeeMap.get(task).doing(task);
    }
}
