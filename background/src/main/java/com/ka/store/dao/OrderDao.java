package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.order.Order_table;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {

    public List<Order_table> selectAllOrder();

    public void insertOrderTable(Order_table order_table);

    public void updateScoreStatus(Order_table order_table);

}
