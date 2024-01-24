package com.ka.store.Service.Commodity.phone.impl;

import com.ka.store.Service.Commodity.phone.PhoneService;
import com.ka.store.dao.CommodityDao;
import com.ka.store.dao.CommodityPhoneDao;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_computer;
import com.ka.store.pojo.commodity.phone.CommodityPhone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PhoneImpl implements PhoneService {

    @Resource
    CommodityPhoneDao commodityPhoneDao;

    @Resource
    CommodityDao commodityDao;

    @Override
    public void insertPhoneInfo(CommodityPhone commodityPhone) {

        commodityPhoneDao.insertPhoneInfo(commodityPhone);
        commodityDao.insertCommodity(commodityPhone.getCommodity());
    }

    @Override
    public CommodityPhone selectPhoneById(String commodity_id) {
        return commodityPhoneDao.selectPhoneById(commodity_id);
    }

    @Override
    public void updatePhoneInfo(CommodityPhone commodityPhone) {

        commodityDao.updateCommodity(commodityPhone.getCommodity());
        commodityPhoneDao.updatePhoneInfo(commodityPhone);
    }

    @Override
    public void deletePhoneInfo(String commodity_id) {
        commodityDao.deleteCommodity(commodity_id);
        commodityPhoneDao.deletePhoneInfo(commodity_id);
    }

    @Override
    public List<CommodityPhone> selectAllPhone() {
        return commodityPhoneDao.selectAllPhone();
    }

    @Override
    public List<CommodityPhone> getPopPhone() {
        return commodityPhoneDao.getPopPhone();
    }

    @Override
    public List<CommodityPhone> selectPhoneByBrand(String brand) {
        return commodityPhoneDao.selectPhoneByBrand(brand);
    }

    @Override
    public List<CommodityPhone> selectByPhoneKeyword(String keyword) {
        return commodityPhoneDao.selectByPhoneKeyword(keyword);
    }

    @Override
    public List<CommodityPhone> selectPhoneOrderPrice() {
        return commodityPhoneDao.selectPhoneOrderPrice();
    }

    @Override
    public List<CommodityPhone> selectPhoneOrderPriceUp() {
        return commodityPhoneDao.selectPhoneOrderPriceUp();
    }

    @Override
    public List<CommodityPhone> selectByPhoneOrderBySaleNumUp() {
        return commodityPhoneDao.selectByPhoneOrderBySaleNumUp();
    }

    @Override
    public List<CommodityPhone> selectByPhoneOrderBySaleNumDown() {
        return commodityPhoneDao.selectByPhoneOrderBySaleNumDown();
    }

    @Override
    public List<CommodityPhone> selectByPhoneOrderByScoreDown() {
        return commodityPhoneDao.selectByPhoneOrderByScoreDown();
    }

    @Override
    public List<CommodityPhone> selectByPhoneOrderByScoreUp() {
        return commodityPhoneDao.selectByPhoneOrderByScoreUp();
    }

    @Override
    public List<CommodityPhone> selectPhoneOrderBySaleNumDownAndKeyword(String keyword) {
        return commodityPhoneDao.selectPhoneOrderBySaleNumDownAndKeyword(keyword);
    }

    @Override
    public List<CommodityPhone> selectPhoneOrderBySaleNumUpAndKeyword(String keyword) {
        return commodityPhoneDao.selectPhoneOrderBySaleNumUpAndKeyword(keyword);
    }

    @Override
    public List<CommodityPhone> selectByPhoneOrderByScoreDownByKeyword(String keyword) {
        return commodityPhoneDao.selectByPhoneOrderByScoreDownByKeyword(keyword);
    }

    @Override
    public List<CommodityPhone> selectByPhoneOrderByScoreUpByKeyword(String keyword) {
        return commodityPhoneDao.selectByPhoneOrderByScoreUpByKeyword(keyword);
    }

    @Override
    public List<CommodityPhone> selectByPhoneOrderByPriceDownByKeyword(String keyword) {
        return commodityPhoneDao.selectByPhoneOrderByPriceDownByKeyword(keyword);
    }

    @Override
    public List<CommodityPhone> selectByPhoneOrderByPriceUpByKeyword(String keyword) {
        return commodityPhoneDao.selectByPhoneOrderByPriceUpByKeyword(keyword);
    }

    @Override
    public List<String> selectPhoneBrand() {
        return commodityPhoneDao.selectPhoneBrand();
    }
}
