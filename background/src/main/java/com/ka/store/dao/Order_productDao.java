package com.ka.store.dao;

import com.ka.store.pojo.order.Order_product;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_productDao {

    public void insertOrderProduct(Order_product order_product);

}
