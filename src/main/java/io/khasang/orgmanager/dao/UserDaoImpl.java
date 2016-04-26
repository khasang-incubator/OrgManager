package io.khasang.orgmanager.dao;


import io.khasang.orgmanager.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoJpa<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }
}
