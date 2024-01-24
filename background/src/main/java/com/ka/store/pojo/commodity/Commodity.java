package com.ka.store.pojo.commodity;

import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Commodity implements Serializable {

    private int id;
    private String commodity_id;
    private String name;
    private String merchant_id;
    private String price;
    private String category;
    private String main_img;
    private String introduce;
    private Sales_commodity sales_commodity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Sales_commodity getSales_commodity() {
        return sales_commodity;
    }

    public void setSales_commodity(Sales_commodity sales_commodity) {
        this.sales_commodity = sales_commodity;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", commodity_id='" + commodity_id + '\'' +
                ", name='" + name + '\'' +
                ", merchant_id='" + merchant_id + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", main_img='" + main_img + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
