package io.khasang.orgmanager.dao.impl;

import io.khasang.orgmanager.model.Entities.News;
import org.springframework.stereotype.Repository;

/**
 * @author radiofisik
 */
@Repository
public class NewsDao extends GenericDaoImpl<News> {
    public NewsDao() {
        super(News.class);
    }
}
