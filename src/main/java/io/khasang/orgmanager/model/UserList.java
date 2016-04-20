package io.khasang.orgmanager.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserList {
    private JdbcTemplate jdbcTemplate;
    private List<User> result;
    public UserList(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void getUserList() {
        String SQL = "select * from UsersList";
        try {
            List<User> userList = jdbcTemplate.query(SQL, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    return user;
                }
            });
            result = userList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getResult() {
        getUserList();
        return result;
    }
}
