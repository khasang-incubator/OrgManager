package io.khasang.orgmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GenericDaoJpa<T> implements GenericDao<T> {

    private Class<T> type;


    @Autowired
    protected SessionFactory sessionFactory;

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
        return getSession().createQuery("select o from"+type.getName()+"o").list();
    }

    @Override
    public void save(T object) {
        if(sessionFactory !=null)
        getSession().persist(object);
        else System.out.println("null-------------------------------------------------");
    }

    @Override
    public void delete(T object) {
        getSession().delete(object);
    }
}
