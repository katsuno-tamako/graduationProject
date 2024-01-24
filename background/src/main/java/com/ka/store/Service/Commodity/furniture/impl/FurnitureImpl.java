package com.ka.store.Service.Commodity.furniture.impl;

import com.ka.store.Service.Commodity.furniture.FurnitureService;
import com.ka.store.dao.CommodityDao;
import com.ka.store.dao.CommodityFurnitureDao;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.furniture.CommodityFurniture;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class FurnitureImpl implements FurnitureService {

    @Resource
    CommodityFurnitureDao commodityFurnitureDao;

    @Resource
    CommodityDao commodityDao;

    @Resource
    Commodity commodity;

    @Override
    public List<CommodityFurniture> selectAllFurniture() {
        return commodityFurnitureDao.selectAllFurniture();
    }

    @Override
    public void insertFurniture(CommodityFurniture furniture) {
        commodityDao.insertCommodity(furniture.getCommodity());
        commodityFurnitureDao.insertFurniture(furniture);
    }

    @Override
    public void updateFurnitureById(CommodityFurniture furniture) {
        commodityDao.updateCommodity(furniture.getCommodity());
        commodityFurnitureDao.updateFurnitureById(furniture);
    }

    @Override
    public void deleteFurnitureById(String commodity_id) {
        commodityDao.deleteCommodity(commodity_id);
        commodityFurnitureDao.deleteFurnitureById(commodity_id);
    }

    @Override
    public CommodityFurniture selectFurnitureById(String commodity_id) {
        return commodityFurnitureDao.selectFurnitureById(commodity_id);
    }

    @Override
    public List<CommodityFurniture> selectFurnitureByKeyword(String keyword) {
        return commodityFurnitureDao.selectFurnitureByKeyword(keyword);
    }

    @Override
    public List<CommodityFurniture> selectFurnitureOrderPrice() {
        return commodityFurnitureDao.selectFurnitureOrderPrice();
    }

    @Override
    public List<CommodityFurniture> selectFurnitureOrderPriceUp() {
        return commodityFurnitureDao.selectFurnitureOrderPriceUp();
    }

    @Override
    public List<CommodityFurniture> selectByFurnitureOrderBySaleNumUp() {
        return commodityFurnitureDao.selectByFurnitureOrderBySaleNumUp();
    }

    @Override
    public List<CommodityFurniture> selectByFurnitureOrderBySaleNumDown() {
        return commodityFurnitureDao.selectByFurnitureOrderBySaleNumDown();
    }

    @Override
    public List<CommodityFurniture> selectByFurnitureOrderByScoreDown() {
        return commodityFurnitureDao.selectByFurnitureOrderByScoreDown();
    }

    @Override
    public List<CommodityFurniture> selectByFurnitureOrderByScoreUp() {
        return commodityFurnitureDao.selectByFurnitureOrderByScoreUp();
    }

    @Override
    public List<CommodityFurniture> selectFurnitureOrderBySaleNumDownAndKeyword(String keyword) {
        return commodityFurnitureDao.selectFurnitureOrderBySaleNumDownAndKeyword(keyword);
    }

    @Override
    public List<CommodityFurniture> selectFurnitureOrderBySaleNumUpAndKeyword(String keyword) {
        return commodityFurnitureDao.selectFurnitureOrderBySaleNumUpAndKeyword(keyword);
    }

    @Override
    public List<CommodityFurniture> selectByFurnitureOrderByScoreDownByKeyword(String keyword) {
        return commodityFurnitureDao.selectByFurnitureOrderByScoreDownByKeyword(keyword);
    }

    @Override
    public List<CommodityFurniture> selectByFurnitureOrderByScoreUpByKeyword(String keyword) {
        return commodityFurnitureDao.selectByFurnitureOrderByScoreUpByKeyword(keyword);
    }

    @Override
    public List<CommodityFurniture> selectByFurnitureOrderByPriceDownByKeyword(String keyword) {
        return commodityFurnitureDao.selectByFurnitureOrderByPriceDownByKeyword(keyword);
    }

    @Override
    public List<CommodityFurniture> selectByFurnitureOrderByPriceUpByKeyword(String keyword) {
        return commodityFurnitureDao.selectByFurnitureOrderByPriceUpByKeyword(keyword);
    }

    @Override
    public List<String> selectFurnitureType() {
        return commodityFurnitureDao.selectFurnitureType();
    }

    @Override
    public List<String> selectFurnitureStyle() {
        return commodityFurnitureDao.selectFurnitureStyle();
    }

    @Override
    public List<String> selectFurnitureBrand() {
        return commodityFurnitureDao.selectFurnitureBrand();
    }


}
