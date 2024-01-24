package com.ka.store.pojo.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class User_acc {

    private int id;
    private String account;
    private String password;
    private String user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "user_acc{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
