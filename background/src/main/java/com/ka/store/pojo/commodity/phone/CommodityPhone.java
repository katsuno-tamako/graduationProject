package com.ka.store.pojo.commodity.phone;

import com.ka.store.pojo.commodity.Commodity;
import org.springframework.stereotype.Component;

@Component
public class CommodityPhone {

    private int id;
    private String commodity_id;
    private String commodity_name;
    private String market_time;
    private String brand;
    private String phone_cpu;
    private String operating_system;
    private String phone_width;
    private String phone_thick;
    private String phone_length;
    private String phone_weight;
    private String storage;
    private String internal_storage;
    private String screen_size;
    private String screen_material;
    private String battery_removable;
    private String wireless_charging;
    private String number_of_sim;
    private String resolution;
    private String backshot_main_pixel;
    private String foreshot_main_pixel;
    private String price;
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

    public String getPhone_cpu() {
        return phone_cpu;
    }

    public void setPhone_cpu(String phone_cpu) {
        this.phone_cpu = phone_cpu;
    }

    public String getOperating_system() {
        return operating_system;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }

    public String getPhone_width() {
        return phone_width;
    }

    public void setPhone_width(String phone_width) {
        this.phone_width = phone_width;
    }

    public String getPhone_thick() {
        return phone_thick;
    }

    public void setPhone_thick(String phone_thick) {
        this.phone_thick = phone_thick;
    }

    public String getPhone_length() {
        return phone_length;
    }

    public void setPhone_length(String phone_length) {
        this.phone_length = phone_length;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getInternal_storage() {
        return internal_storage;
    }

    public void setInternal_storage(String internal_storage) {
        this.internal_storage = internal_storage;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(String screen_size) {
        this.screen_size = screen_size;
    }

    public String getScreen_material() {
        return screen_material;
    }

    public void setScreen_material(String screen_material) {
        this.screen_material = screen_material;
    }

    public String getBattery_removable() {
        return battery_removable;
    }

    public void setBattery_removable(String battery_removable) {
        this.battery_removable = battery_removable;
    }

    public String getWireless_charging() {
        return wireless_charging;
    }

    public void setWireless_charging(String wireless_charging) {
        this.wireless_charging = wireless_charging;
    }

    public String getNumber_of_sim() {
        return number_of_sim;
    }

    public void setNumber_of_sim(String number_of_sim) {
        this.number_of_sim = number_of_sim;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getBackshot_main_pixel() {
        return backshot_main_pixel;
    }

    public void setBackshot_main_pixel(String backshot_main_pixel) {
        this.backshot_main_pixel = backshot_main_pixel;
    }

    public String getForeshot_main_pixel() {
        return foreshot_main_pixel;
    }

    public void setForeshot_main_pixel(String foreshot_main_pixel) {
        this.foreshot_main_pixel = foreshot_main_pixel;
    }

    public String getPhone_weight() {
        return phone_weight;
    }

    public void setPhone_weight(String phone_weight) {
        this.phone_weight = phone_weight;
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
        return "CommodityPhone{" +
                "id=" + id +
                ", commodity_id='" + commodity_id + '\'' +
                ", commodity_name='" + commodity_name + '\'' +
                ", market_time='" + market_time + '\'' +
                ", brand='" + brand + '\'' +
                ", phone_cpu='" + phone_cpu + '\'' +
                ", operating_system='" + operating_system + '\'' +
                ", phone_width='" + phone_width + '\'' +
                ", phone_thick='" + phone_thick + '\'' +
                ", phone_length='" + phone_length + '\'' +
                ", storage='" + storage + '\'' +
                ", internal_storage='" + internal_storage + '\'' +
                ", screen_size='" + screen_size + '\'' +
                ", screen_material='" + screen_material + '\'' +
                ", battery_removable='" + battery_removable + '\'' +
                ", wireless_charging='" + wireless_charging + '\'' +
                ", number_of_sim='" + number_of_sim + '\'' +
                ", resolution='" + resolution + '\'' +
                ", Backshot_main_pixel='" + backshot_main_pixel + '\'' +
                ", Foreshot_main_pixel='" + foreshot_main_pixel + '\'' +
                '}';
    }
}
