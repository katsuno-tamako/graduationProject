package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.order.Merchant_order;
import org.springframework.stereotype.Repository;

@Repository
public interface Merchant_orderDao {

    public List<Merchant_order> selectAllOrderByAllMerchant();

    public void insertOrder_MerchantTable(Merchant_order merchant_order);

    public List<Merchant_order> selectOrderMerchantTableByMerchantId(String merchant_id);

    public void updateMerchantTableStatus(Merchant_order merchant_order);

    public void updateLogisticsStatus(Merchant_order merchant_order);

    public List<Merchant_order> selectOrderByUser(String user_id);

    public Merchant_order selectOrderById(Merchant_order merchant_order);

    public int getOrderNumber();
}
