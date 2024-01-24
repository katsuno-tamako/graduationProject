package com.ka.store.pojo.commodity.Category;

import org.springframework.stereotype.Component;

@Component
public class CategoryType {

    private int id;
    private String category;
    private String category_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory_type() {
        return category_type;
    }

    public void setCategory_type(String category_type) {
        this.category_type = category_type;
    }

    @Override
    public String toString() {
        return "CategoryType{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", category_type='" + category_type + '\'' +
                '}';
    }
}
