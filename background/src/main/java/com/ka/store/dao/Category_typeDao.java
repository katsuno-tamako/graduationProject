package com.ka.store.dao;
import java.util.List;

import com.ka.store.pojo.commodity.Category.CategoryType;
import org.springframework.stereotype.Repository;

@Repository
public interface Category_typeDao {

    public List<CategoryType> selectAllCategoryType();

    public void insertCategoryType(CategoryType categoryType);

    public void deleteCategoryType(CategoryType categoryType);

    public List<CategoryType> selectCategoryTypeTableByCategory(String category);

}
