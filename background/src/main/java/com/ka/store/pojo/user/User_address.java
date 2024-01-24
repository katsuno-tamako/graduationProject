package com.ka.store.pojo.user;

import org.springframework.stereotype.Component;

@Component
public class User_address {

    private int id;
    private String user_id;
    private String address;
    private String user_name;
    private String tag;
    private String phone;
    private String user_address_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUser_address_id() {
        return user_address_id;
    }

    public void setUser_address_id(String user_address_id) {
        this.user_address_id = user_address_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "User_address{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", address='" + address + '\'' +
                ", user_name='" + user_name + '\'' +
                ", tag='" + tag + '\'' +
                ", phone='" + phone + '\'' +
                ", default_address='" + user_address_id + '\'' +
                '}';
    }
}
