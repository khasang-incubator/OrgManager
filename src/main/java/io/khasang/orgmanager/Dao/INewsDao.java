package io.khasang.orgmanager.dao;

import io.khasang.orgmanager.model.Entities.News;

import java.util.List;

public interface INewsDao extends GenericDao<News>{
    int NEWS_ON_PAGE_COUNT = 10;

    News getNewsByName(String newsname);
    int getAllNewsCount();
    int getNewsPagesCount();
    List<News> getNewsOnPage(int pageNumber);
}
