package com.ka.store.Controller.Category;
import java.util.List;
import com.ka.store.Service.Category.CategoryTypeService;
import com.ka.store.Service.Category.CommodityTypeService;
import com.ka.store.pojo.commodity.Category.CategoryType;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.type.CommodityType.Commodity_type;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    CategoryTypeService categoryTypeService;

    @Resource
    CommodityTypeService commodityTypeService;

    @RequestMapping("/selectAllCategoryType")
    public List<CategoryType> selectAllCategoryType(){
        return categoryTypeService.selectAllCategoryType();
    }

        @RequestMapping("/insertCategoryType")
    public void insertCategoryType(@RequestBody CategoryType categoryType){
            System.out.println(categoryType);
        categoryTypeService.insertCategoryType(categoryType);
    }

    @RequestMapping("/deleteCategoryType")
    public void deleteCategoryType(@RequestBody CategoryType categoryType){
        categoryTypeService.deleteCategoryType(categoryType);
    }

    @RequestMapping("/selectCategoryTypeTableByCategory")
    public List<CategoryType> selectCategoryTypeTableByCategory(@RequestParam  String category){
        return categoryTypeService.selectCategoryTypeTableByCategory(category);
    }


}
