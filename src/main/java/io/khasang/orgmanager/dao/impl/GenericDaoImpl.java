package io.khasang.orgmanager.dao.impl;


import io.khasang.orgmanager.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class GenericDaoImpl <T> implements GenericDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> type;

    protected Session getSession() {
        if(sessionFactory!=null)
        return sessionFactory.getCurrentSession();
        else throw new NullPointerException("autowire failed");
    }

    public GenericDaoImpl(Class<T> type){
        this.type = type;
    }

    @Transactional(readOnly = true)
    public T get(Integer id) {
        return (T) getSession().createCriteria(type).
                add( Restrictions.idEq(id) ).
                uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<T> getAll() {
        return getSession().createCriteria(type).list();
    }

    @Transactional
    public void save(T object) {
        getSession().saveOrUpdate(object);
    }

    @Transactional
    public void delete(T object) {
        getSession().delete(object);
    }
}
