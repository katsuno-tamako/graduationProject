package com.ka.store.Service.Order;

import com.ka.store.pojo.order.Merchant_order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Merchant_orderService {

    public List<Merchant_order> selectAllOrderByAllMerchant();

    public void insertOrder_MerchantTable(Merchant_order merchant_order);

    public List<Merchant_order> selectOrderMerchantTableByMerchantId(String merchant_id);

    public void updateMerchantTableStatus(Merchant_order merchant_order);

    public void updateLogisticsStatus(Merchant_order merchant_order);

    public List<Merchant_order> selectOrderByUser(String user_id);

    public Merchant_order selectOrderById(Merchant_order merchant_order);

    public int getOrderNumber();


}
