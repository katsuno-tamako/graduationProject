package com.ka.store.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface Page_ViewDao {

    public int getPageView();

    public void addPageView();

}
