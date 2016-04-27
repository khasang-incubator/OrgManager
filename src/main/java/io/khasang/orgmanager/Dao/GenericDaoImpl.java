package io.khasang.orgmanager.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class GenericDaoImpl <T> implements GenericDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> type;

    private Session getSession() {
        if(sessionFactory!=null)
        return sessionFactory.getCurrentSession();
        else throw new NullPointerException("autowire failed");
    }

    public GenericDaoImpl(Class<T> type){
        this.type = type;
    }

    @Transactional(readOnly = true)
    public T get(Long id) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<T> getAll() {
        return getSession().createCriteria(type).list();
    }

    @Transactional
    public void save(T object) {
        getSession().persist(object);
    }

    @Transactional
    public void delete(T object) {
        getSession().delete(object);
    }
}
