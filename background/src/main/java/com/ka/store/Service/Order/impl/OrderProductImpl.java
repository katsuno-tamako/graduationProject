package com.ka.store.Service.Order.impl;

import com.ka.store.Service.Order.OrderProductService;
import com.ka.store.dao.Order_productDao;
import com.ka.store.pojo.order.Order_product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class OrderProductImpl implements OrderProductService {

    @Resource
    Order_productDao order_productDao;

    @Override
    public void insertOrderProduct(Order_product order_product) {
        order_productDao.insertOrderProduct(order_product);
    }
}
