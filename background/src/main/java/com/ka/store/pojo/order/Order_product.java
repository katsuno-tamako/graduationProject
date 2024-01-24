package com.ka.store.pojo.order;

import org.springframework.stereotype.Component;

@Component
public class Order_product {

    private int id;
    private String order_id;
    private String merchant_id;
    private String commodity_id;
    private int num;
    private String order_price;

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

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }
}
