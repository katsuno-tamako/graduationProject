package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.commodity.Categories;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao {

    public List<Categories> selectAllCategories();

}
