package com.ka.store.Service.Commodity.other.impl;

import com.ka.store.Service.Commodity.other.OtherService;
import com.ka.store.dao.CommodityDao;
import com.ka.store.dao.OtherDao;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.other.Other;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OtherImpl implements OtherService {

    @Resource
    OtherDao otherDao;

    @Resource
    Commodity commodity;

    @Resource
    CommodityDao commodityDao;

    @Override
    public void insertOtherCommodity(Other other) {
        commodityDao.insertCommodity(other.getCommodity());
        otherDao.insertOtherCommodity(other);
    }

    @Override
    public List<Other> selectAllOtherCommodity() {
        return otherDao.selectAllOtherCommodity();
    }

    @Override
    public Other selectOtherCommodityById(String commodity_id) {
        return otherDao.selectOtherCommodityById(commodity_id);
    }

    @Override
    public void updateOtherCommodity(Other other) {
        commodityDao.updateCommodity(other.getCommodity());
        otherDao.updateOtherCommodity(other);
    }

    @Override
    public void deleteOtherCommodityById(String commodity_id) {
        commodityDao.deleteCommodity(commodity_id);
        otherDao.deleteOtherCommodityById(commodity_id);
    }
}
