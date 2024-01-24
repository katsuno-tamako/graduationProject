package com.ka.store.Service.Order.impl;

import com.ka.store.Service.Order.OrderMainService;
import com.ka.store.dao.OrderMainDao;
import com.ka.store.pojo.order.Order_main;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OrderMainImpl implements OrderMainService {

    @Resource
    OrderMainDao orderMainDao;

    @Override
    public List<Order_main> selectAllOrderMain() {
        return orderMainDao.selectAllOrderMain();
    }

    @Override
    public void insertOrderMain(Order_main order_main) {
        orderMainDao.insertOrderMain(order_main);
    }

    @Override
    public List<Order_main> selectOrderMainByMerchant(String merchant_id) {
        return orderMainDao.selectOrderMainByMerchant(merchant_id);
    }

    @Override
    public void updateOrderLogistic(Order_main order_main) {
        orderMainDao.updateOrderLogistic(order_main);
    }
}
