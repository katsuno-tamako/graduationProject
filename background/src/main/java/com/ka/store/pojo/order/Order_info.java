package com.ka.store.pojo.order;

import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.user.User_address;
import org.springframework.stereotype.Component;

@Component
public class Order_info {

    private int id;
    private String order_id;
    private String commodity_id;
    private String user_id;
    private String merchant_id;
    private int num;
    private String user_address_id;
    private Commodity commodity;
    private String order_date;
    private String order_wait_receive;
    private String order_delivered;
    private User_address user_address;

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
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

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_wait_receive() {
        return order_wait_receive;
    }

    public void setOrder_wait_receive(String order_wait_receive) {
        this.order_wait_receive = order_wait_receive;
    }

    public String getOrder_delivered() {
        return order_delivered;
    }

    public void setOrder_delivered(String order_delivered) {
        this.order_delivered = order_delivered;
    }

    @Override
    public String toString() {
        return "Order_info{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", commodity_id='" + commodity_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", merchant_id='" + merchant_id + '\'' +
                ", num=" + num +
                ", user_address_id='" + user_address_id + '\'' +
                ", commodity=" + commodity +
                ", order_date='" + order_date + '\'' +
                ", order_wait_receive='" + order_wait_receive + '\'' +
                ", order_delivered='" + order_delivered + '\'' +
                ", user_address=" + user_address +
                '}';
    }
}
