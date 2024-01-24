package com.ka.store.pojo.admin;

import org.springframework.stereotype.Component;

@Component
public class HomeImg {

    private int id;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
