package com.ka.store.pojo.merchant;

import org.springframework.stereotype.Component;

@Component
public class Merchant_Info {

    private int id;
    private String merchant_id;
    private String merchant_name;
    private String merchant_address;
    private String merchant_number;
    private String merchant_email;
    private String person_id;
    private String mer_intro;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getMerchant_address() {
        return merchant_address;
    }

    public void setMerchant_address(String merchant_address) {
        this.merchant_address = merchant_address;
    }

    public String getMerchant_number() {
        return merchant_number;
    }

    public void setMerchant_number(String merchant_number) {
        this.merchant_number = merchant_number;
    }

    public String getMerchant_email() {
        return merchant_email;
    }

    public void setMerchant_email(String merchant_email) {
        this.merchant_email = merchant_email;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMer_intro() {
        return mer_intro;
    }

    public void setMer_intro(String mer_intro) {
        this.mer_intro = mer_intro;
    }
}
