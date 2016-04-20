package io.khasang.orgmanager.model;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class SelectTopThree {
    private static final String URL = "jdbc:postgresql://localhost:5432/orgmanager";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public ArrayList<String> statment() {

        ArrayList<String> result = new ArrayList<>();
        String query = "SELECT * FROM test WHERE id > 0 LIMIT 3;";

        try (Connection conn = connect()) {

            Statement stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(query);
            while (resultSet.next()) {
                result.add(resultSet.getString(2));
            }
        } catch (SQLException e) {
            result.add("Ошибка");
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            result.add("Ошибка");
            e.getStackTrace();
        }
        return result;
    }
}
