package com.ka.store.Controller.Commodity;
import java.util.List;

import com.ka.store.Service.CategoryService;
import com.ka.store.pojo.commodity.Categories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Categories")
public class CategoriesController {

    @Resource
    CategoryService categoryService;

        @RequestMapping("/selectAllCategories")
    public List<Categories> returnCategories(){
        System.out.println(categoryService.selectAllCategories());
        return categoryService.selectAllCategories();
    }


}
