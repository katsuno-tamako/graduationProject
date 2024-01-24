package com.ka.store.pojo.merchant;

import org.springframework.stereotype.Component;

@Component
public class Apply_merchant {

    private int id;
    private String apply_id;
    private String merchant_name;
    private String account;
    private String password;
    private String apply_info;
    private String merchant_id;
    private String apply_date;
    private String merchant_email;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getApply_info() {
        return apply_info;
    }

    public void setApply_info(String apply_info) {
        this.apply_info = apply_info;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getApply_date() {
        return apply_date;
    }

    public void setApply_date(String apply_date) {
        this.apply_date = apply_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchant_email() {
        return merchant_email;
    }

    public void setMerchant_email(String merchant_email) {
        this.merchant_email = merchant_email;
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

    @Override
    public String toString() {
        return "Apply_merchant{" +
                "id=" + id +
                ", apply_id='" + apply_id + '\'' +
                ", merchant_name='" + merchant_name + '\'' +
                ", apply_info='" + apply_info + '\'' +
                ", merchant_id='" + merchant_id + '\'' +
                ", apply_date='" + apply_date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
