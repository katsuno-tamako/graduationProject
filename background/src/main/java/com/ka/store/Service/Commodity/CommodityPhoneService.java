package com.ka.store.Service.Commodity;

import com.ka.store.pojo.commodity.allCategory.Commodity_categories_phone;
import org.springframework.stereotype.Service;

@Service
public interface CommodityPhoneService {

    public void insertPhone(Commodity_categories_phone commodity_categories_phone);

    public Commodity_categories_phone selectPhoneById(String commodity_id);

}
