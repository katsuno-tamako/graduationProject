package com.ka.store.Service.page.impl;

import com.ka.store.Service.page.Page_viewService;
import com.ka.store.dao.Page_ViewDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class Page_viewImpl implements Page_viewService {

    @Resource
    Page_ViewDao page_viewDao;

    @Override
    public int getPageView() {
        return page_viewDao.getPageView();
    }

    @Override
    public void addPageView() {
        page_viewDao.addPageView();
    }
}
