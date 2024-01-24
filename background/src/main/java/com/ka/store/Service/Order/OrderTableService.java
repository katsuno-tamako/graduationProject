package com.ka.store.Service.Order;
import java.util.List;
import com.ka.store.pojo.order.Order_table;
import org.springframework.stereotype.Service;

@Service
public interface OrderTableService {

    public List<Order_table> selectOrderTable();

    public void insertOrderTable(Order_table order_table);

    public void updateScoreStatus(Order_table order_table);


}
