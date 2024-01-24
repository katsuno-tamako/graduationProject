package com.ka.store.pojo.merchant;

import org.springframework.stereotype.Repository;

@Repository
public class Merchant_lo {

    private int id;
    private String account;
    private String password;
    private String merchantID;

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

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    @Override
    public String toString() {
        return "merchant_lo{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", merchantID='" + merchantID + '\'' +
                '}';
    }
}
