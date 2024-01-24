package com.ka.store.Service.Category;

import com.ka.store.pojo.commodity.Category.CategoryType;
import com.ka.store.pojo.commodity.type.CommodityType.Commodity_type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryTypeService {


    public List<CategoryType> selectAllCategoryType();

    public void insertCategoryType(CategoryType categoryType);

    public void deleteCategoryType(CategoryType categoryType);

    public List<CategoryType> selectCategoryTypeTableByCategory(String category);


}
