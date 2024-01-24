package com.ka.store.pojo.order;

import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.merchant.Merchant_Info;
import org.springframework.stereotype.Component;

@Component
public class Shopping_cart {

    private int id;
    private String user_id;
    private String commodity_id;
    private Commodity commodity;
    private int num;
    private String merchant_id;
    private Merchant_Info merchant_info;

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

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public Merchant_Info getMerchant_info() {
        return merchant_info;
    }

    public void setMerchant_info(Merchant_Info merchant_info) {
        this.merchant_info = merchant_info;
    }

    @Override
    public String toString() {
        return "Shopping_cart{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", commodity_id='" + commodity_id + '\'' +
                ", commodity=" + commodity +
                ", num=" + num +
                ", merchant_id='" + merchant_id + '\'' +
                ", merchant_info=" + merchant_info +
                '}';
    }
}
