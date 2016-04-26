package io.khasang.orgmanager.dao;


import io.khasang.orgmanager.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class UserDaoImpl extends GenericDaoJpa<User> implements UserDao {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }
}
