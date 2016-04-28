package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.dao.impl.GenericDaoImpl;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDaoImpl<User>  {
    public UserDao() {
        super(User.class);
    }
}
