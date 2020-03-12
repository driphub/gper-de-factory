package com.pger.de.template.jdbc.dao;

import com.pger.de.template.jdbc.entity.Member;
import com.pger.de.template.jdbc.framework.JdbcTemplate;
import com.pger.de.template.jdbc.framework.RowMapper;
import org.apache.xpath.operations.String;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends JdbcTemplate {
    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from t_member");

        return super.excuteQuery(sql.toString(), new RowMapper<Member>() {
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));

                return member;
            }
        }, null);
    }


}
