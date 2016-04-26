package io.khasang.orgmanager.dao;

import io.khasang.orgmanager.model.Entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }
}
