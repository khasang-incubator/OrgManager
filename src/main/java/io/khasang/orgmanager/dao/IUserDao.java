package io.khasang.orgmanager.dao;

import io.khasang.orgmanager.model.Entities.User;

public interface IUserDao extends GenericDao<User> {
    User getUserByName(String username);
}
