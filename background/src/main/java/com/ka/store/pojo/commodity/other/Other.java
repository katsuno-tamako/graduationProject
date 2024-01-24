package com.ka.store.pojo.commodity.other;

import com.ka.store.pojo.commodity.Commodity;
import org.springframework.stereotype.Component;

@Component
public class Other {

    private int id;
    private String commodity_name;
    private String commodity_id;
    private String commodity_type;
    private String commodity_intro;
    private String price;
    private Commodity commodity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getCommodity_type() {
        return commodity_type;
    }

    public void setCommodity_type(String commodity_type) {
        this.commodity_type = commodity_type;
    }

    public String getCommodity_intro() {
        return commodity_intro;
    }

    public void setCommodity_intro(String commodity_intro) {
        this.commodity_intro = commodity_intro;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "Other{" +
                "id=" + id +
                ", commodity_name='" + commodity_name + '\'' +
                ", commodity_id='" + commodity_id + '\'' +
                ", commodity_type='" + commodity_type + '\'' +
                ", commodity_intro='" + commodity_intro + '\'' +
                ", price='" + price + '\'' +
                ", commodity=" + commodity +
                '}';
    }
}
