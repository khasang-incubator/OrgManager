package io.khasang.orgmanager.dao.implementation;

import io.khasang.orgmanager.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class GenericDaoJpa<T> implements GenericDao<T> {

    private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public GenericDaoJpa(Class<T> type) {
        super();
        this.type = type;
    }

    @Transactional(readOnly = true)
    public T get(Long id) {
        if (id == null) {
            return null;
        } else {
            return getSession().get(type, id);
        }
    }

    @Transactional(readOnly = true)
    public List<T> getAll() {
        return getSession().createCriteria(type).list();
    }

    @Override
    public void save(T object) {
        if(sessionFactory !=null)
        getSession().persist(object);
        else System.out.println("autowire failed");
    }

    @Override
    public void delete(T object) {
        getSession().delete(object);
    }
}
