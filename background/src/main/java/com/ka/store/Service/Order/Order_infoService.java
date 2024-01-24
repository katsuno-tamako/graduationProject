package com.ka.store.Service.Order;
import java.util.List;
import com.ka.store.pojo.order.Order_info;
import org.springframework.stereotype.Service;

@Service
public interface Order_infoService {

    public void insertOrderId(Order_info order_info);

    public List<Order_info> selectAll();

    public List<Order_info> selectOrderByMerchant(String merchant_id);

    public List<Order_info> selectOrderByUser(String user_id);

    public String equOrder(String commodity_id,String user_id);

    public List<Order_info> selectOrderByDelivered(Order_info order_info);

    public List<Order_info> selectOrderByReceive(Order_info order_info);

    public void updateOrderStatusDe(Order_info order_info);

    public void updateOrderStatusRs(Order_info order_info);

    public List<Order_info> selectOrderByDeliveredByMerchantId(Order_info order_info);

    public List<Order_info> selectOrderByReceiveByMerchantId(Order_info order_info);



}
