package com.ka.store.dao;

import com.ka.store.pojo.merchant.Merchant_Info;
import com.ka.store.pojo.merchant.Merchant_lo;
import org.springframework.stereotype.Repository;

@Repository
public interface Merchant_loDao {

    public Merchant_lo merchantLogin(Merchant_lo merchant_lo);

    public void insertMerchantLo(Merchant_lo merchant_lo);


}
