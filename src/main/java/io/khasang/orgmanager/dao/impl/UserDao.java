package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.dao.impl.GenericDaoImpl;
import io.khasang.orgmanager.model.Entities.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao extends GenericDaoImpl<User> implements IUserDao {
    public UserDao() {
        super(User.class);
    }

    @Override
    public User getUserByName(String username) {
        return (User) getSession().createCriteria( User.class ).
                add( Restrictions.eq("name", username) ).
                uniqueResult();
    }
}
