package com.ka.store.pojo.commodity.furniture;

import com.ka.store.pojo.commodity.Commodity;
import org.springframework.stereotype.Component;

@Component
public class CommodityFurniture {

    private int id;
    private String name;
    private String price;
    private String commodity_id;
    private String furniture_material;
    private String scene;
    private String function_type;
    private String furniture_weight;
    private String furniture_area;
    private String furniture_style;
    private String brand;
    private String room;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getFurniture_material() {
        return furniture_material;
    }

    public void setFurniture_material(String furniture_material) {
        this.furniture_material = furniture_material;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getFunction_type() {
        return function_type;
    }

    public void setFunction_type(String function_type) {
        this.function_type = function_type;
    }

    public String getFurniture_weight() {
        return furniture_weight;
    }

    public void setFurniture_weight(String furniture_weight) {
        this.furniture_weight = furniture_weight;
    }

    public String getFurniture_area() {
        return furniture_area;
    }

    public void setFurniture_area(String furniture_area) {
        this.furniture_area = furniture_area;
    }

    public String getFurniture_style() {
        return furniture_style;
    }

    public void setFurniture_style(String furniture_style) {
        this.furniture_style = furniture_style;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "CommodityFurniture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", commodity_id='" + commodity_id + '\'' +
                ", furniture_material='" + furniture_material + '\'' +
                ", scene='" + scene + '\'' +
                ", function_type='" + function_type + '\'' +
                ", furniture_weight='" + furniture_weight + '\'' +
                ", furniture_area='" + furniture_area + '\'' +
                ", furniture_style='" + furniture_style + '\'' +
                ", brand='" + brand + '\'' +
                ", room='" + room + '\'' +
                ", commodity=" + commodity +
                '}';
    }
}
