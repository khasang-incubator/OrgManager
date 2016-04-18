package io.khasang.orgmanager.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class DataSelect {
    private JdbcTemplate jdbcTemplate;
    private String result;

    public DataSelect(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createDataTable(String tableName) {
        try {
            jdbcTemplate.execute("CREATE TABLE COMPANY " +
                            "(ID INT PRIMARY KEY     NOT NULL)");
            result = "Table " + tableName + " created sucesfull!";
        } catch (Exception e) {
            result = e + " " + tableName;
            e.printStackTrace();
        }
    }

    public String getResult() {
        createDataTable("test");
        return result;
    }
}