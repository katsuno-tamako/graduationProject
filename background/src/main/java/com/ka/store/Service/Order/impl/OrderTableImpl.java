package com.ka.store.Service.Order.impl;

import com.ka.store.Service.Order.OrderTableService;
import com.ka.store.dao.OrderDao;
import com.ka.store.pojo.order.Order_table;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OrderTableImpl implements OrderTableService {

    @Resource
    OrderDao orderDao;

    @Override
    public List<Order_table> selectOrderTable() {
        return orderDao.selectAllOrder();
    }

    @Override
    public void insertOrderTable(Order_table order_table) {
        orderDao.insertOrderTable(order_table);
    }

    @Override
    public void updateScoreStatus(Order_table order_table) {
        orderDao.updateScoreStatus(order_table);
    }
}
