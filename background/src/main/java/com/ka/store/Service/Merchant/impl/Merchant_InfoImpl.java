package com.ka.store.Service.Merchant.impl;

import com.ka.store.Service.Merchant.Merchant_InfoService;
import com.ka.store.dao.Merchant_InfoDao;
import com.ka.store.pojo.merchant.Merchant_Info;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Merchant_InfoImpl implements Merchant_InfoService {

    @Resource
    Merchant_InfoDao merchant_infoDao;

    @Override
    public Merchant_Info selectMerchantByMerchantID(String merchantID) {
        return merchant_infoDao.selectMerchantByMerchantID(merchantID);
    }

    @Override
    public List<Merchant_Info> selectAllMerchant() {
        return merchant_infoDao.selectAllMerchant();
    }

    @Override
    public void updateMerInfo(Merchant_Info merchant_info) {
        merchant_infoDao.updateMerInfo(merchant_info);
    }

    @Override
    public void upHeadImg(Merchant_Info merchant_info) {
        merchant_infoDao.upHeadImg(merchant_info);
    }
}
