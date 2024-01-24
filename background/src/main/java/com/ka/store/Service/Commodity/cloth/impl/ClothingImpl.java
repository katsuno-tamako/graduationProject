package com.ka.store.Service.Commodity.cloth.impl;

import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Commodity.cloth.ClothingService;
import com.ka.store.dao.CommodityClothingDao;
import com.ka.store.dao.CommodityDao;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.CommodityImg;
import com.ka.store.pojo.commodity.clothing.CommodityClothing;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ClothingImpl implements ClothingService {

    @Resource
    CommodityDao commodityDao;

    @Resource
    CommodityService commodityService;

    @Resource
    CommodityClothingDao commodityClothingDao;

    @Override
    public List<CommodityClothing> selectAllClothing() {
        return commodityClothingDao.selectAllCloth();
    }

    @Override
    public void insertCloth(CommodityClothing commodityClothing) {
        commodityClothingDao.insetCloth(commodityClothing);
        commodityDao.insertCommodity(commodityClothing.getCommodity());
    }

    @Override
    public CommodityClothing selectClothById(String Commodity_id) {
        return commodityClothingDao.selectClothById(Commodity_id);
    }

    @Override
    public void updateClothById(CommodityClothing commodityClothing) {
        commodityDao.updateCommodity(commodityClothing.getCommodity());
        commodityClothingDao.updateClothById(commodityClothing);
    }

    @Override
    public void deleteClothById(String commodity_id) {
        System.out.println("删除的id："+commodity_id);
        commodityService.deleteCommodity(commodity_id);
        commodityClothingDao.deleteClothById(commodity_id);
    }

    @Override
    public List<CommodityClothing> selectClothByKeyword(String keyword) {
        return commodityClothingDao.selectClothByKeyword(keyword);
    }

    @Override
    public List<CommodityClothing> selectClothOrderPrice() {
        return commodityClothingDao.selectClothOrderPrice();
    }

    @Override
    public List<CommodityClothing> selectClothOrderPriceUp() {
        return commodityClothingDao.selectClothOrderPriceUp();
    }

    @Override
    public List<CommodityClothing> selectByClothOrderBySaleNumUp() {
        return commodityClothingDao.selectByClothOrderBySaleNumUp();
    }

    @Override
    public List<CommodityClothing> selectByClothOrderBySaleNumDown() {
        return commodityClothingDao.selectByClothOrderBySaleNumDown();
    }

    @Override
    public List<CommodityClothing> selectByClothOrderByScoreDown() {
        return commodityClothingDao.selectByClothOrderByScoreDown();
    }

    @Override
    public List<CommodityClothing> selectByClothOrderByScoreUp() {
        return commodityClothingDao.selectByClothOrderByScoreUp();
    }

    @Override
    public List<CommodityClothing> selectClothOrderBySaleNumDownAndKeyword(String keyword) {
        return commodityClothingDao.selectClothOrderBySaleNumDownAndKeyword(keyword);
    }

    @Override
    public List<CommodityClothing> selectClothOrderBySaleNumUpAndKeyword(String keyword) {
        return commodityClothingDao.selectClothOrderBySaleNumUpAndKeyword(keyword);
    }

    @Override
    public List<CommodityClothing> selectByClothOrderByScoreDownByKeyword(String keyword) {
        return commodityClothingDao.selectByClothOrderByScoreDownByKeyword(keyword);
    }

    @Override
    public List<CommodityClothing> selectByClothOrderByScoreUpByKeyword(String keyword) {
        return commodityClothingDao.selectByClothOrderByScoreUpByKeyword(keyword);
    }

    @Override
    public List<CommodityClothing> selectByClothOrderByPriceDownByKeyword(String keyword) {
        return commodityClothingDao.selectByClothOrderByPriceDownByKeyword(keyword);
    }

    @Override
    public List<CommodityClothing> selectByClothOrderByPriceUpByKeyword(String keyword) {
        return commodityClothingDao.selectByClothOrderByPriceUpByKeyword(keyword);
    }

    @Override
    public List<String> selectClothBrand() {
        return commodityClothingDao.selectClothBrand();
    }

    @Override
    public List<String> selectClothSuitable() {
        return commodityClothingDao.selectClothSuitable();
    }

    @Override
    public List<String> selectClothStyle() {
        return commodityClothingDao.selectClothStyle();
    }

    @Override
    public List<String> selectClothType() {
        return commodityClothingDao.selectClothType();
    }
}
