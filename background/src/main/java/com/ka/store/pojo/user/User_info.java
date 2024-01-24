package com.ka.store.pojo.user;

import org.springframework.stereotype.Component;

@Component
public class User_info {
    private int id;
    private String user_id;
    private String phone;
    private String email;
    private String birthday;
    private String sex;
    private String img;
    private String user_name;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "User_info{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
