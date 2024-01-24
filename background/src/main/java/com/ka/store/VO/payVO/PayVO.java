package com.ka.store.VO.payVO;

import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.order.Shopping_cart;
import com.ka.store.pojo.user.User_address;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.awt.*;

@Component
public class PayVO implements Serializable {

    private String user_address;
    private Commodity[] commodities;
    private String[] merchant_id;
    private Shopping_cart[] shopping_carts;

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public Commodity[] getCommodities() {
        return commodities;
    }

    public void setCommodities(Commodity[] commodities) {
        this.commodities = commodities;
    }

    public String[] getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String[] merchant_id) {
        this.merchant_id = merchant_id;
    }

    public Shopping_cart[] getShopping_carts() {
        return shopping_carts;
    }

    public void setShopping_carts(Shopping_cart[] shopping_carts) {
        this.shopping_carts = shopping_carts;
    }

    @Override
    public String toString() {
        return "PayVO{" +
                "user_address='" + user_address + '\'' +
                ", commodities=" + Arrays.toString(commodities) +
                ", merchant_id=" + Arrays.toString(merchant_id) +
                ", shopping_carts=" + Arrays.toString(shopping_carts) +
                '}';
    }
}
