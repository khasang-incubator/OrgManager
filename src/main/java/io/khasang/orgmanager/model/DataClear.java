package io.khasang.orgmanager.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This model is designed to clean the data from the database
 * @author Serega Bobrus
 * @version 1.0
 */
public class DataClear {
    private JdbcTemplate jdbcTemplate;
    private String result = "";

    public DataClear(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Method removes the last row of the table
     * @param tableName - table name
     * @author Serega Bobrus
     * @version 1.0
     */
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

    /**
     * Method deletes the data in a given time interval for table "users"
     * @param lowerBound - starting date
     * @param upperBound - end date
     * @author Serega Bobrus
     * @version 1.0
     */
    public void deletePeriodDate(Date lowerBound, Date upperBound) {
        try {
            jdbcTemplate.execute("DELETE FROM users WHERE BIRTHDAY > '" + lowerBound + "' AND BIRTHDAY < '" + upperBound + "';");
            result = "Data deleted from " + lowerBound + " to " + upperBound;
        } catch (Exception e) {
            result = e + "";
            e.printStackTrace();
        }
    }

    /**
     * Method removes the last row of the table "users"
     * @return status work deleteLastData
     * @author Serega Bobrus
     * @version 1.0
     */
    public String getResultDeleteLastData() {
        deleteLastData("users");
        return result;
    }

    /**
     * Method deletes the data in time interval from 1980-06-10 before 1990-03-15 for table "users"
     * @return status work deletePeriodDate
     * @author Serega Bobrus
     * @version 1.0
     */
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
