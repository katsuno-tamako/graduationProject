package com.ka.store.Service.Commodity.impl;

import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.dao.CommodityDao;
import com.ka.store.pojo.commodity.Commodity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CommodityImpl implements CommodityService {

    @Resource
    CommodityDao commodityDao;

    @Override
    public List<Commodity> selectCommodityByMerchant(String merchantID) {
        return commodityDao.selectCommodityByMerchant(merchantID);
    }

    @Override
    public void updateCommodity(Commodity commodity) {
        System.out.println("Service:"+commodity);
        commodityDao.updateCommodity(commodity);
    }

    @Override
    public void deleteCommodity(String commodity_id) {
        commodityDao.deleteCommodity(commodity_id);
    }

    @Override
    public Commodity selectCommodityById(String commodity_id) {
        return commodityDao.selectCommodityById(commodity_id);
    }

    @Override
    public void updateMainImg(String commodity_id, String path) {
        commodityDao.updateMainImg(commodity_id,path);
    }

    @Override
    public List<Commodity> selectByCategory(String category){
        return commodityDao.selectByCategory(category);
    }

    @Override
    public List<Commodity> searchCommodity(String keyword) {
        return commodityDao.searchCommodity(keyword);
    }

    @Override
    public void insertMainImg(String commodity_id, String main_ing) {
        commodityDao.insertMainImg(commodity_id,main_ing);
    }

    @Override
    public List<String> merchantHaveCategory(String merchant_id) {
        return commodityDao.merchantHaveCategory(merchant_id);
    }

    @Override
    public List<Commodity> selectCommodityByMerchantAndCategory(Commodity commodity) {
        return commodityDao.selectCommodityByMerchantAndCategory(commodity);
    }

    @Override
    public String selectMerchantByCommodityId(String commodity_id) {
        return commodityDao.selectMerchantByCommodityId(commodity_id);
    }

    @Override
    public List<Commodity> selectCommodityOrderPrice(String keyword) {
        return commodityDao.selectCommodityOrderPrice(keyword);
    }

    @Override
    public List<Commodity> selectCommodityOrderPriceUp(String keyword) {
        return commodityDao.selectCommodityOrderPriceUp(keyword);
    }

    @Override
    public List<Commodity> selectByCommodityOrderBySaleNumUp(String keyword) {
        return commodityDao.selectByCommodityOrderBySaleNumUp(keyword);
    }

    @Override
    public List<Commodity> selectByCommodityOrderBySaleNumDown(String keyword) {
        return commodityDao.selectByCommodityOrderBySaleNumDown(keyword);
    }

    @Override
    public List<Commodity> selectByCommodityOrderByScoreDown(String keyword) {
        return commodityDao.selectByCommodityOrderByScoreDown(keyword);
    }

    @Override
    public List<Commodity> selectByCommodityOrderByScoreUp(String keyword) {
        return commodityDao.selectByCommodityOrderByScoreUp(keyword);
    }

    @Override
    public List<Commodity> recommendCommodity() {
        return commodityDao.recommendCommodity();
    }

    @Override
    public List<Commodity> topGrade() {
        return commodityDao.topGrade();
    }

}
