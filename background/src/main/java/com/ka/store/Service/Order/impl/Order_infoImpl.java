package com.ka.store.Service.Order.impl;

import com.ka.store.Service.Order.Order_infoService;
import com.ka.store.dao.Order_infoDao;
import com.ka.store.pojo.order.Order_info;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Order_infoImpl implements Order_infoService {

    @Resource
    Order_infoDao order_infoDao;

    @Override
    public void insertOrderId(Order_info order_info) {
        System.out.println(order_info);
        order_infoDao.insertOrderInfo(order_info);
    }

    @Override
    public List<Order_info> selectAll() {
        return order_infoDao.selectAll();
    }

    @Override
    public List<Order_info> selectOrderByMerchant(String merchant_id) {
        return order_infoDao.selectOrderByMerchant(merchant_id);
    }

    @Override
    public List<Order_info> selectOrderByUser(String user_id) {
        return order_infoDao.selectOrderByUser(user_id);
    }

    @Override
    public String equOrder(String commodity_id, String user_id) {
        List<Order_info> order_infos = order_infoDao.equOrder(commodity_id,user_id);
        System.out.println("equOrder info :" + order_infos);
        System.out.println(order_infos.size());
        if(order_infos.size()==0){
            return "No";
        }else {
            return "Yes";
        }
    }

    @Override
    public List<Order_info> selectOrderByDelivered(Order_info order_info) {
        System.out.println("selectOrderByDelivered");
        return order_infoDao.selectOrderByDelivered(order_info);
    }

    @Override
    public List<Order_info> selectOrderByReceive(Order_info order_info) {
        System.out.println("selectOrderByReceive");
        return order_infoDao.selectOrderByReceive(order_info);
    }

    @Override
    public void updateOrderStatusDe(Order_info order_info) {
        order_infoDao.updateOrderStatusDe(order_info);
    }

    @Override
    public void updateOrderStatusRs(Order_info order_info) {
        order_infoDao.updateOrderStatusRs(order_info);
    }

    @Override
    public List<Order_info> selectOrderByDeliveredByMerchantId(Order_info order_info) {
        return order_infoDao.selectOrderByDeliveredByMerchantId(order_info);
    }

    @Override
    public List<Order_info> selectOrderByReceiveByMerchantId(Order_info order_info) {
        return order_infoDao.selectOrderByReceiveByMerchantId(order_info);
    }
}
