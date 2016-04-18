package io.khasang.orgmanager.model;

import org.hibernate.mapping.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



public class DataSelect {
    private JdbcTemplate jdbcTemplate;
    private String result;

    public DataSelect(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createDataTable() {
        try {
            jdbcTemplate.execute("DROP TABLE  IF EXISTS  users");

            jdbcTemplate.execute("CREATE TABLE users " +
                    "(id SERIAL PRIMARY KEY, name TEXT, password TEXT)");
            result = "Table created sucesfull!";
        } catch (Exception e) {
            result = e + " ";
            e.printStackTrace();
        }
    }

    public void insertUser(String user, String password){
        try {
            jdbcTemplate.execute("INSERT INTO users (name, password) VALUES ('"+user+"','"+password+"')");
        } catch (Exception e) {
            result = e.getStackTrace().toString();
            e.printStackTrace();
        }
    }

    public List<String> getUsers(){
        List<String> users=new ArrayList<>();
        try {
           List<java.util.Map<String, Object>> rows=jdbcTemplate.queryForList("SELECT name FROM users");
            for(java.util.Map<String, Object> row: rows){
                users.add((String) row.get("name"));
            }
        } catch (Exception e) {
            result = e.getStackTrace().toString();
            e.printStackTrace();
        }
        return users;
    }

    public String getResult() {
        createDataTable();
        insertUser("user1","passw0rd");
        insertUser("user5","passw0r5d");
        return result;
    }
}
