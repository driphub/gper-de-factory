package com.pger.de.template.jdbc;

import com.pger.de.template.jdbc.dao.MemberDao;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao(null);
        List<?> result = dao.selectAll();
        System.out.printf("---------->" + result.size());
    }
}
