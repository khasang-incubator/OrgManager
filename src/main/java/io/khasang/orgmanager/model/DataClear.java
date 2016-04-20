package io.khasang.orgmanager.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataClear {
    private JdbcTemplate jdbcTemplate;
    private String result = "";

    public DataClear(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteLastData(String tableName) {
        try {
            jdbcTemplate.execute("DELETE FROM " + tableName +
                    " WHERE id = (SELECT MAX(id) FROM " + tableName + ") ");
            result = "Delete last data to " + tableName;
        } catch (Exception e) {
            result = e + " " + tableName;
            e.printStackTrace();
        }
    }

    public void deletePeriodDate(Date lowerBound, Date upperBound) { //interval
        try {
            jdbcTemplate.execute("DELETE FROM users WHERE BIRTHDAY > '" + lowerBound + "' AND BIRTHDAY < '" + upperBound + "';");
            result = "Data deleted from " + lowerBound + " to " + upperBound;
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
    }

    public String getResultDeleteLastData() {
        deleteLastData("users");
        return result;
    }

    public String getResultDeletePeriodDate() {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            Date lowerBound = format.parse("19800610");
            Date upperBound = format.parse("19900315");
            deletePeriodDate(new java.sql.Date(lowerBound.getTime()), new java.sql.Date(upperBound.getTime()));
        } catch (ParseException e) {
            result = result + e;
            e.printStackTrace();
        }
        return result;
    }

}
