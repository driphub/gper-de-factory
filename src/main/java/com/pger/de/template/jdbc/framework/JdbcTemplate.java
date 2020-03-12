package com.pger.de.template.jdbc.framework;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> excuteQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            Connection connection = this.getConnection();

            PreparedStatement pstm = this.createPreparedStatement(connection, sql);

            ResultSet rs = this.excuteQuery(pstm, values);

            List<?> result = this.parseResultSet(rs, rowMapper);

            rs.close();

            pstm.close();

            connection.close();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    private List<?> parseResultSet(ResultSet rs, RowMapper<?> mapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int rowNum = 0;
        while (rs.next()) {
            result.add(mapper.mapRow(rs, rowNum++));
        }
        return result;
    }

    private ResultSet excuteQuery(PreparedStatement pstm, Object[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            pstm.setObject(i, values[i]);
        }
        return pstm.executeQuery();
    }

    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    private PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
