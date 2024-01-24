package com.ka.store.pojo.commodity;

import org.springframework.stereotype.Component;

@Component
public class CommodityImg {

    private int id;
    private String commodity_id;
    private String path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "CommodityImg{" +
                "id=" + id +
                ", commodity_id='" + commodity_id + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
