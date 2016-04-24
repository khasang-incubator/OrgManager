package io.khasang.orgmanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DataSelect {
    @Autowired
    Environment environment;
    private JdbcTemplate jdbcTemplate;
    private String result;

    /**
     * @autor Radiofisik
     * @version 1.0
     * method makes backup of database. see /resources/config.properties file for properties
     */
    public String makeBackup() {
        final List<String> baseCmds = new ArrayList<String>();
        baseCmds.add(environment.getProperty("backup.processorpath"));
        baseCmds.add("-h");
        baseCmds.add(environment.getProperty("backup.hostname"));
        baseCmds.add("-p");
        baseCmds.add(environment.getProperty("backup.port"));
        baseCmds.add("-U");
        baseCmds.add(environment.getProperty("backup.user"));
        baseCmds.add("-b");
        baseCmds.add("-v");
        baseCmds.add("-f");
        baseCmds.add(environment.getProperty("backup.destinationfile"));
        baseCmds.add(environment.getProperty("backup.db"));
        final ProcessBuilder pb = new ProcessBuilder(baseCmds);
        // Set the password
        final Map<String, String> env = pb.environment();
        env.put("PGPASSWORD", environment.getProperty("backup.password"));
        try {
            final Process process = pb.start();
            final BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            StringBuffer sb=new StringBuffer();
            while ((line =r.readLine())!= null) {
                sb.append(line);
            }
            r.close();
            final int dcertExitCode = process.waitFor();
            return sb.toString();

        } catch (IOException e) {
            return "error happened"+e.getMessage();
        } catch (InterruptedException ie) {
            return "error happened"+ie.getMessage();
        }
    }

    /**
     * @autor Radiofisik
     * @version 1.0
     * method selects users from database
     */
    public DataSelect(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void createDataTable() {
        try {
            jdbcTemplate.execute("DROP TABLE  IF EXISTS  users");

            jdbcTemplate.execute("CREATE TABLE users " +
                    "(id SERIAL PRIMARY KEY, name TEXT, password TEXT)");
            result = "Table selected successful!";
        } catch (Exception e) {
            result = e + " ";
            e.printStackTrace();
        }
    }

    /**
     * @autor Radiofisik
     * @version 1.0
     * method inserts user to database
     * @param user - the name of the user
     * @param password - the password of the user
     */
    public void insertUser(String user, String password) {
        try {
            jdbcTemplate.execute("INSERT INTO users (name, password) VALUES ('" + user + "','" + password + "')");
        } catch (Exception e) {
            result = e.getStackTrace().toString();
            e.printStackTrace();
        }
    }

    public List<String> getUsers() {
        List<String> users = new ArrayList<>();
        try {
            List<java.util.Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT name FROM users");
            for (java.util.Map<String, Object> row : rows) {
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
        insertUser("user1", "passw0rd");
        insertUser("user5", "passw0r5d");
        return result;
    }
}
