package com.ka.store.Service.Category.impl;

import com.ka.store.Service.Category.CategoryTypeService;
import com.ka.store.dao.Category_typeDao;
import com.ka.store.dao.Commodity_typeDao;
import com.ka.store.pojo.commodity.Category.CategoryType;
import com.ka.store.pojo.commodity.type.CommodityType.Commodity_type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CategoryTypeImpl implements CategoryTypeService {

    @Resource
    Category_typeDao category_typeDao;

    @Override
    public List<CategoryType> selectAllCategoryType() {
        return category_typeDao.selectAllCategoryType();
    }

    @Override
    public void insertCategoryType(CategoryType categoryType) {
        category_typeDao.insertCategoryType(categoryType);
    }

    @Override
    public void deleteCategoryType(CategoryType categoryType) {
        category_typeDao.deleteCategoryType(categoryType);
    }

    @Override
    public List<CategoryType> selectCategoryTypeTableByCategory(String category) {
        return category_typeDao.selectCategoryTypeTableByCategory(category);
    }
}
