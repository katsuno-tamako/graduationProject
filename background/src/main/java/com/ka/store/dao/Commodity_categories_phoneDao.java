package com.ka.store.dao;

import com.ka.store.pojo.commodity.allCategory.Commodity_categories_phone;
import org.springframework.stereotype.Repository;

@Repository
public interface Commodity_categories_phoneDao {

    public void insertPhone(Commodity_categories_phone commodity_categories_phone);

    public Commodity_categories_phone selectPhoneById(String commodity_id);

}
