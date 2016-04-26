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

@Component
public class DataSelect {
    @Autowired
    Environment environment;
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

}
