package com.ka.store.dao;
import java.util.List;

import com.ka.store.pojo.order.Order_main;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMainDao {

    public List<Order_main> selectAllOrderMain();

    public List<Order_main> selectOrderMainByMerchant(String merchant_id);

    public void insertOrderMain(Order_main order_main);

    public void updateOrderLogistic(Order_main order_main);

}
