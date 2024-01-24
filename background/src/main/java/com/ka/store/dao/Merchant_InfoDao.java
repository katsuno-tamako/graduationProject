package com.ka.store.dao;

import com.ka.store.pojo.merchant.Merchant_Info;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Merchant_InfoDao {

    public Merchant_Info selectMerchantByMerchantID(String merchant_id);

    public List<Merchant_Info> selectAllMerchant();

    public void insertMerchant_info(Merchant_Info merchant_info);

    public void updateMerInfo(Merchant_Info merchant_info);

    public void upHeadImg(Merchant_Info merchant_info);

    public List<Merchant_Info> selectMerchantOrderGroupBy();

    public void updateOrderStatus();

}
