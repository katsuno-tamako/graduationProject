package com.ka.store.Service.Order;
import java.util.List;

import com.ka.store.pojo.order.Order_main;
import org.springframework.stereotype.Service;

@Service
public interface OrderMainService {

    public List<Order_main> selectAllOrderMain();

    public void insertOrderMain(Order_main order_main);

    public List<Order_main> selectOrderMainByMerchant(String merchant_id);

    public void updateOrderLogistic(Order_main order_main);


}
