package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.dao.INewsDao;
import io.khasang.orgmanager.model.Entities.News;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author radiofisik
 */
@Repository
public class NewsDao extends GenericDaoImpl<News> implements INewsDao {
    public NewsDao() {
        super(News.class);
    }

    @Override
    public News getNewsByName(String newsname) {
        return (News) getSession().createCriteria( News.class ).
                add( Restrictions.eq("name", newsname) ).
                uniqueResult();
    }

    @Override
    public int getAllNewsCount(){
        return ((Number) getSession().createCriteria(News.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
                //.list().size();
    }

    @Override
    public int getNewsPagesCount(){
        return getAllNewsCount() / NEWS_ON_PAGE_COUNT;
    }

    @Override
    public List<News> getNewsOnPage(int pageNumber){
        return getSession().createCriteria(News.class).setFirstResult(pageNumber * NEWS_ON_PAGE_COUNT).setMaxResults(NEWS_ON_PAGE_COUNT).list();
    }
}
