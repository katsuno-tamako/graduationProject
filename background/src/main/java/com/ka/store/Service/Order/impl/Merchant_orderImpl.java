package com.ka.store.Service.Order.impl;

import com.ka.store.Service.Order.Merchant_orderService;
import com.ka.store.dao.Merchant_orderDao;
import com.ka.store.pojo.order.Merchant_order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Merchant_orderImpl implements Merchant_orderService {

    @Resource
    Merchant_orderDao merchant_orderDao;

    @Override
    public List<Merchant_order> selectAllOrderByAllMerchant() {
        return merchant_orderDao.selectAllOrderByAllMerchant();
    }

    @Override
    public void insertOrder_MerchantTable(Merchant_order merchant_order) {
        merchant_orderDao.insertOrder_MerchantTable(merchant_order);
    }

    @Override
    public List<Merchant_order> selectOrderMerchantTableByMerchantId(String merchant_id) {
        return merchant_orderDao.selectOrderMerchantTableByMerchantId(merchant_id);
    }

    @Override
    public void updateMerchantTableStatus(Merchant_order merchant_order) {
        merchant_orderDao.updateMerchantTableStatus(merchant_order);
    }

    @Override
    public void updateLogisticsStatus(Merchant_order merchant_order) {
        merchant_orderDao.updateLogisticsStatus(merchant_order);
    }

    @Override
    public List<Merchant_order> selectOrderByUser(String user_id) {
        return merchant_orderDao.selectOrderByUser(user_id);
    }

    @Override
    public Merchant_order selectOrderById(Merchant_order merchant_order) {
        return merchant_orderDao.selectOrderById(merchant_order);
    }

    @Override
    public int getOrderNumber() {
        return merchant_orderDao.getOrderNumber();
    }
}
