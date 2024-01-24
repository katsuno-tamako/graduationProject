package com.ka.store.Service.impl;

import com.ka.store.Service.CategoryService;
import com.ka.store.dao.CategoryDao;
import com.ka.store.pojo.commodity.Categories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class CategoryImpl implements CategoryService {

    @Resource
    CategoryDao categoryDao;

    @Override
    public List<Categories> selectAllCategories() {
        return categoryDao.selectAllCategories();
    }
}
