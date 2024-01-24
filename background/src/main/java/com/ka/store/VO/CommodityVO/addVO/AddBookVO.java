package com.ka.store.VO.CommodityVO.addVO;

import com.ka.store.pojo.commodity.Category.CategoryType;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_books;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AddBookVO {

    private Commodity_categories_books commodity_categories_books;
    private String[] categoryTypes;

    public Commodity_categories_books getCommodity_categories_books() {
        return commodity_categories_books;
    }

    public void setCommodity_categories_books(Commodity_categories_books commodity_categories_books) {
        this.commodity_categories_books = commodity_categories_books;
    }

    public String[] getCategoryTypes() {
        return categoryTypes;
    }

    public void setCategoryTypes(String[] categoryTypes) {
        this.categoryTypes = categoryTypes;
    }

    @Override
    public String toString() {
        return "addBookVO{" +
                "commodity_categories_books=" + commodity_categories_books +
                ", categoryTypes=" + Arrays.toString(categoryTypes) +
                '}';
    }
}
