package com.ka.store.Service;
import java.util.List;
import com.ka.store.pojo.commodity.Categories;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    public List<Categories> selectAllCategories();

}
