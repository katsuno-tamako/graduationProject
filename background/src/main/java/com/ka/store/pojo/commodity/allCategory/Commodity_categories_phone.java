package com.ka.store.pojo.commodity.allCategory;

import com.ka.store.pojo.commodity.Commodity;
import org.springframework.stereotype.Component;

@Component
public class Commodity_categories_phone {

    private int id;
    private String phone_name;
    private String commodity_id;
    private String phone_cpu;
    private String phone_price;
    private String phone_memory;
    private String phone_system;
    private String phone_storage;
    private String phone_brand;
    private String phone_length;
    private String phone_weight;
    private String  main_pixel;
    private String  phone_resolution;
    private Commodity commodity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone_name() {
        return phone_name;
    }

    public void setPhone_name(String phone_name) {
        this.phone_name = phone_name;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getPhone_cpu() {
        return phone_cpu;
    }

    public void setPhone_cpu(String phone_cpu) {
        this.phone_cpu = phone_cpu;
    }

    public String getPhone_price() {
        return phone_price;
    }

    public void setPhone_price(String phone_price) {
        this.phone_price = phone_price;
    }

    public String getPhone_memory() {
        return phone_memory;
    }

    public void setPhone_memory(String phone_memory) {
        this.phone_memory = phone_memory;
    }

    public String getPhone_system() {
        return phone_system;
    }

    public void setPhone_system(String phone_system) {
        this.phone_system = phone_system;
    }

    public String getPhone_storage() {
        return phone_storage;
    }

    public void setPhone_storage(String phone_storage) {
        this.phone_storage = phone_storage;
    }

    public String getPhone_brand() {
        return phone_brand;
    }

    public void setPhone_brand(String phone_brand) {
        this.phone_brand = phone_brand;
    }

    public String getPhone_length() {
        return phone_length;
    }

    public void setPhone_length(String phone_length) {
        this.phone_length = phone_length;
    }

    public String getPhone_weight() {
        return phone_weight;
    }

    public void setPhone_weight(String phone_weight) {
        this.phone_weight = phone_weight;
    }

    public String getMain_pixel() {
        return main_pixel;
    }

    public void setMain_pixel(String main_pixel) {
        this.main_pixel = main_pixel;
    }

    public String getPhone_resolution() {
        return phone_resolution;
    }

    public void setPhone_resolution(String phone_resolution) {
        this.phone_resolution = phone_resolution;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "Commodity_categories_phone{" +
                "id=" + id +
                ", phone_name='" + phone_name + '\'' +
                ", commodity_id='" + commodity_id + '\'' +
                ", phone_cpu='" + phone_cpu + '\'' +
                ", phone_price='" + phone_price + '\'' +
                ", phone_memory='" + phone_memory + '\'' +
                ", phone_system='" + phone_system + '\'' +
                ", phone_storage='" + phone_storage + '\'' +
                ", phone_brand='" + phone_brand + '\'' +
                ", phone_length='" + phone_length + '\'' +
                ", phone_weight='" + phone_weight + '\'' +
                ", main_pixel='" + main_pixel + '\'' +
                ", phone_resolution='" + phone_resolution + '\'' +
                ", commodity=" + commodity +
                '}';
    }
}
