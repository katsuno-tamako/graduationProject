package com.ka.store.Service.Merchant.impl;

import com.ka.store.Service.Merchant.Merchant_loService;
import com.ka.store.dao.Merchant_loDao;
import com.ka.store.pojo.merchant.Merchant_lo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class Merchant_loImpl implements Merchant_loService {

    @Resource
    Merchant_loDao merchant_loDao;

    @Override
    public Merchant_lo MerchantLogin(Merchant_lo merchant_lo) {
        return merchant_loDao.merchantLogin(merchant_lo);
    }
}
