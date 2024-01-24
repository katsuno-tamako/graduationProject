package com.ka.store.Service.Merchant;

import com.ka.store.pojo.merchant.Merchant_Info;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface Merchant_InfoService {

    public Merchant_Info selectMerchantByMerchantID(String merchantID);

    public List<Merchant_Info> selectAllMerchant();

    public void updateMerInfo(Merchant_Info merchant_info);

    public void upHeadImg(Merchant_Info merchant_info);


}
