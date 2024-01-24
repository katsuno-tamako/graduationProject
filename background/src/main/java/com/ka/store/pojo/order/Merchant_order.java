package com.ka.store.pojo.order;
import java.util.List;

import com.ka.store.pojo.user.User_address;
import org.springframework.stereotype.Component;

@Component
public class Merchant_order {

    private int MOId;
    private String merchant_id;
    private String order_id;
    private String order_status;
    private String logistics_id;
    private String order_date;
    private String user_address_id;
    private User_address user_address;
    private List<Order_table> order_tables;

    public int getMOId() {
        return MOId;
    }

    public void setMOId(int MOId) {
        this.MOId = MOId;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public List<Order_table> getOrder_tables() {
        return order_tables;
    }

    public void setOrder_tables(List<Order_table> order_tables) {
        this.order_tables = order_tables;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getLogistics_id() {
        return logistics_id;
    }

    public void setLogistics_id(String logistics_id) {
        this.logistics_id = logistics_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getUser_address_id() {
        return user_address_id;
    }

    public void setUser_address_id(String user_address_id) {
        this.user_address_id = user_address_id;
    }

    public User_address getUser_address() {
        return user_address;
    }

    public void setUser_address(User_address user_address) {
        this.user_address = user_address;
    }

    @Override
    public String toString() {
        return "Merchant_order{" +
                "MOId=" + MOId +
                ", merchant_id='" + merchant_id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", order_status='" + order_status + '\'' +
                ", logistics_id='" + logistics_id + '\'' +
                ", order_date='" + order_date + '\'' +
                ", order_tables=" + order_tables +
                '}';
    }
}
