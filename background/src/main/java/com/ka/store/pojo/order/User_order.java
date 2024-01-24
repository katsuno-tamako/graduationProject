package com.ka.store.pojo.order;

import org.springframework.stereotype.Component;

@Component
public class User_order {

    private int id;
    private String user_id;
    private String order_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Order_user{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
