package com.ka.store.pojo.comment;

import org.springframework.stereotype.Component;

@Component
public class User_commodity_evaluate {

    private int id;
    private String commodity_id;
    private String user_id;

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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return "User_commodity_evaluate{" +
                "id=" + id +
                ", commodity_id='" + commodity_id + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
