package com.ka.store.Service.Commodity.impl;

import com.ka.store.Service.Commodity.CommodityPhoneService;
import com.ka.store.dao.CommodityDao;
import com.ka.store.dao.Commodity_categories_phoneDao;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_phone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CommodityPhoneImpl implements CommodityPhoneService {

    @Resource
    Commodity_categories_phoneDao commodity_categories_phoneDao;

    @Resource
    CommodityDao commodityDao;

    @Override
    public void insertPhone(Commodity_categories_phone commodity_categories_phone) {
        commodity_categories_phoneDao.insertPhone(commodity_categories_phone);
        commodityDao.insertCommodity(commodity_categories_phone.getCommodity());
    }

    @Override
    public Commodity_categories_phone selectPhoneById(String commodity_id) {
        return commodity_categories_phoneDao.selectPhoneById(commodity_id);
    }
}
