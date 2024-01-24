package com.ka.store.Service.Merchant.impl;

import com.ka.store.Service.Merchant.Apply_merchantService;
import com.ka.store.Service.Merchant.Merchant_InfoService;
import com.ka.store.dao.Apply_merchantDao;
import com.ka.store.dao.Merchant_InfoDao;
import com.ka.store.dao.Merchant_loDao;
import com.ka.store.pojo.merchant.Apply_merchant;
import com.ka.store.pojo.merchant.Merchant_Info;
import com.ka.store.pojo.merchant.Merchant_lo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Apply_merchantImpl implements Apply_merchantService {

    @Resource
    Apply_merchantDao apply_merchantDao;

    @Resource
    Merchant_Info merchant_info;

    @Resource
    Merchant_lo merchant_lo;

    @Resource
    Merchant_InfoDao merchant_infoDao;

    @Resource
    Merchant_loDao merchant_loDao;

    @Override
    public void insertApplyMerchant(Apply_merchant apply_merchant) {
        apply_merchantDao.insertApplyMerchant(apply_merchant);
    }

    @Override
    public List<Apply_merchant> selectAllApplyMerchant() {
        return apply_merchantDao.selectAllApplyMerchant();
    }

    @Override
    public void updateApplyStatus(Apply_merchant apply_merchant) {
        merchant_info.setMerchant_id(apply_merchant.getMerchant_id());
        merchant_info.setMerchant_email(apply_merchant.getMerchant_name());
        merchant_info.setMerchant_name(apply_merchant.getMerchant_name());
        merchant_lo.setAccount(apply_merchant.getAccount());
        merchant_lo.setPassword(apply_merchant.getPassword());
        merchant_lo.setMerchantID(apply_merchant.getMerchant_id());

        merchant_infoDao.insertMerchant_info(merchant_info);
        merchant_loDao.insertMerchantLo(merchant_lo);
        apply_merchantDao.updateApplyStatus(apply_merchant);
    }
}
