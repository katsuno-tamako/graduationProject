package com.ka.store.pojo.commodity.type.CommodityType;

import org.springframework.stereotype.Component;

@Component
public class Commodity_type {

    private int ctid;
    private String commodity_id;
    private String commodity_type;

    public int getCtid() {
        return ctid;
    }

    public void setCtid(int ctid) {
        this.ctid = ctid;
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

    @Override
    public String toString() {
        return "Commodity_type{" +
                "id=" + ctid +
                ", commodity_id='" + commodity_id + '\'' +
                ", commodity_type='" + commodity_type + '\'' +
                '}';
    }
}
