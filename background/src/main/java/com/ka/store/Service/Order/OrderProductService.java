package com.ka.store.Service.Order;

import com.ka.store.pojo.order.Order_product;
import org.springframework.stereotype.Service;

@Service
public interface OrderProductService {

    public void insertOrderProduct(Order_product order_product);

}
