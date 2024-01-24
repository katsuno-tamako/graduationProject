package com.ka.store.pojo.commodity.food;

import com.ka.store.pojo.commodity.Commodity;
import org.springframework.stereotype.Component;

@Component
public class Food {

    private int id;
    private String name;
    private String commodity_id;
    private String price;
    private String food_type;
    private String food_weight;
    private String origin;
    private String production_license_number;
    private String product_standard_number;
    private String net_content;
    private String ex;
    private Commodity commodity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public String getFood_weight() {
        return food_weight;
    }

    public void setFood_weight(String food_weight) {
        this.food_weight = food_weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProduction_license_number() {
        return production_license_number;
    }

    public void setProduction_license_number(String production_license_number) {
        this.production_license_number = production_license_number;
    }

    public String getProduct_standard_number() {
        return product_standard_number;
    }

    public void setProduct_standard_number(String product_standard_number) {
        this.product_standard_number = product_standard_number;
    }

    public String getNet_content() {
        return net_content;
    }

    public void setNet_content(String net_content) {
        this.net_content = net_content;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", commodity_id='" + commodity_id + '\'' +
                ", price='" + price + '\'' +
                ", food_type='" + food_type + '\'' +
                ", food_weight='" + food_weight + '\'' +
                ", origin='" + origin + '\'' +
                ", production_license_number='" + production_license_number + '\'' +
                ", product_standard_number='" + product_standard_number + '\'' +
                ", net_content='" + net_content + '\'' +
                ", ex='" + ex + '\'' +
                '}';
    }
}
