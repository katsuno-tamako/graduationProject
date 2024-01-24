package com.ka.store.pojo.order;

import org.springframework.stereotype.Component;

@Component
public class Commodity_order {

    private int id;
    private String order_id;
    private String commodity_id;

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

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    @Override
    public String toString() {
        return "Commodity_order{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", commodity_id='" + commodity_id + '\'' +
                '}';
    }
}


