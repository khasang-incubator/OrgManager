package io.khasang.orgmanager.dao;


import io.khasang.orgmanager.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class UserDao extends GenericDaoJpa<User> {
    public UserDao() {
        super(User.class);
    }
}
