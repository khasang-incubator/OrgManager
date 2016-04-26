package io.khasang.orgmanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
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
	
    public DataSelect(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createDataTable(String tableName) {
        try {
            jdbcTemplate.execute("CREATE TABLE COMPANY " +
                            "(ID INT PRIMARY KEY     NOT NULL)");
            result = "Table " + tableName + " created successful!";
        } catch (Exception e) {
            result = e + " " + tableName;
            e.printStackTrace();
        }
    }

    /*
     *  Делает выборку из БД по inner join
     *  @param tableName Имя таблицы, источника данных
     *  @param joinTableName Имя таблицы для присоединения
     *  @return List<String[]> всех подходящих строк таблицы БД, если успешно, null, при возникновении исключения
     *  @author Андрей Поляков
     *  @version 1.0
     */
    public List<String[]> selectWiwthInnerJoin(String tableName, String joinTableName){
        List<String[]> selectResult = new ArrayList<>();
        try {
            SqlRowSet resultSet = jdbcTemplate.queryForRowSet(
                    "SELECT resources.name, users.nick\n" +
                            "FROM " + tableName + "\n" +
                            "INNER JOIN " + joinTableName + " ON " + tableName + ".\"user_ID\"=" + joinTableName + ".id\n" +
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

    /*
     * @return Результат выполнения selectWiwthInnerJoin
     * @author Андрей Поляков
     * @version 1.0
     */
    public List<String[]> getSelectResult(){
        return selectWiwthInnerJoin("resources", "users");
    }
}