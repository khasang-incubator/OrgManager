package io.khasang.orgmanager.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<String[]> selectWiwthInnerJoin(String tableName, String joinTableName){
        List<String[]> selectResult = new ArrayList<>();
        try {
            ResultSet resultSet = (ResultSet) jdbcTemplate.queryForRowSet(
                    "SELECT resources.name, users.nick\n" +
                            "FROM " + tableName + "\n" +
                            "INNER JOIN " + joinTableName + " ON " + joinTableName + ".id = " + tableName + ".userid\n" +
                            "ORDER BY " + tableName + ".name;");
            while (resultSet.next()) {
                String resourceName = resultSet.getString(1);
                String userName = resultSet.getString(2);
                selectResult.add(new String[]{resourceName, userName});
            }
        } catch (Exception e) {
            result = e + " " + tableName;
            e.printStackTrace();
            selectResult.add(new String[]{e + " " + tableName, ""});
        }
        return selectResult;
    }

    public String getResult() {
        createDataTable("test");
        return result;
    }

    public List<String[]> getSelectResult(){
        return selectWiwthInnerJoin("resources", "users");
    }
}