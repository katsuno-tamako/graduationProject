package com.ka.store.pojo.commodity.allCategory;

import com.ka.store.pojo.commodity.Commodity;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Commodity_categories_computer implements Serializable {

    private int id;
    private String commodity_id;
    private String computer_name;
    private String computer_type;
    private String price;
    private String cpu;
    private String memory;
    private String disk;
    private String system;
    private String resolution;
    private String brand;
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

    public String getComputer_name() {
        return computer_name;
    }

    public void setComputer_name(String computer_name) {
        this.computer_name = computer_name;
    }

    public String getComputer_type() {
        return computer_type;
    }

    public void setComputer_type(String computer_type) {
        this.computer_type = computer_type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCPU() {
        return cpu;
    }

    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "Commodity_categories_computer{" +
                "id=" + id +
                ", commodity_id='" + commodity_id + '\'' +
                ", computer_name='" + computer_name + '\'' +
                ", computer_type='" + computer_type + '\'' +
                ", price='" + price + '\'' +
                ", CPU='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                ", system='" + system + '\'' +
                ", resolution='" + resolution + '\'' +
                ", brand='" + brand + '\'' +
                ", commodity=" + commodity +
                '}';
    }
}
