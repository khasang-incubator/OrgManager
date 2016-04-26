package io.khasang.orgmanager.dao.implementation;

import io.khasang.orgmanager.dao.UserDao;
import io.khasang.orgmanager.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoJpa<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }
}
