package com.ka.store.pojo.commodity.clothing;

import com.ka.store.pojo.commodity.Commodity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CommodityClothing {

    private int id;
    private String commodity_id;
    private String commodity_name;
    private String market_time;
    private String brand;
    private String price;
    private String cloth_type;
    private String apply_to_session;
    private String commodity_weight;
    private String suitable;
    private String clothing_style;
    private Commodity commodity;

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

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getMarket_time() {
        return market_time;
    }

    public void setMarket_time(String market_time) {
        this.market_time = market_time;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCloth_type() {
        return cloth_type;
    }

    public void setCloth_type(String cloth_type) {
        this.cloth_type = cloth_type;
    }

    public String getApply_to_session() {
        return apply_to_session;
    }

    public void setApply_to_session(String apply_to_session) {
        this.apply_to_session = apply_to_session;
    }

    public String getCommodity_weight() {
        return commodity_weight;
    }

    public void setCommodity_weight(String commodity_weight) {
        this.commodity_weight = commodity_weight;
    }

    public String getSuitable() {
        return suitable;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }

    public String getClothing_style() {
        return clothing_style;
    }

    public void setClothing_style(String clothing_style) {
        this.clothing_style = clothing_style;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "CommodityClothing{" +
                "id=" + id +
                ", commodity_id='" + commodity_id + '\'' +
                ", commodity_name='" + commodity_name + '\'' +
                ", market_time='" + market_time + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", type='" + cloth_type + '\'' +
                ", apply_to_session='" + apply_to_session + '\'' +
                ", commodity_weight='" + commodity_weight + '\'' +
                ", suitable='" + suitable + '\'' +
                ", clothing_style='" + clothing_style + '\'' +
                ", commodity=" + commodity +
                '}';
    }
}
