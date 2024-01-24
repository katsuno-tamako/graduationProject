package com.ka.store.Service.Commodity.food.impl;

import com.ka.store.Service.Commodity.food.FoodService;
import com.ka.store.dao.CommodityDao;
import com.ka.store.dao.CommodityFoodDao;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.food.Food;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class FoodImpl implements FoodService {

    @Resource
    CommodityFoodDao commodityFoodDao;

    @Resource
    CommodityDao commodityDao;

    @Override
    public List<Food> selectAllFood() {
        return commodityFoodDao.selectAllFood();
    }

    @Override
    public void insertFoodInfo(Food food) {
        commodityFoodDao.insertFoodInfo(food);
        commodityDao.insertCommodity(food.getCommodity());
    }

    @Override
    public void updateFoodInfo(Food food) {
        commodityFoodDao.updateFoodInfo(food);
        commodityDao.updateCommodity(food.getCommodity());
    }

    @Override
    public Food selectFoodById(String commodity_id) {
        return commodityFoodDao.selectFoodById(commodity_id);
    }

    @Override
    public void deleteFoodById(String commodity_id) {
        commodityFoodDao.deleteFoodById(commodity_id);
    }

    @Override
    public List<Food> selectFoodByKeyword(String keyword) {
        return commodityFoodDao.selectFoodByKeyword(keyword);
    }

    @Override
    public List<Food> selectFoodOrderPrice() {
        return commodityFoodDao.selectFoodOrderPrice();
    }

    @Override
    public List<Food> selectFoodOrderPriceUp() {
        return commodityFoodDao.selectFoodOrderPriceUp();
    }

    @Override
    public List<Food> selectByFoodOrderBySaleNumUp() {
        return commodityFoodDao.selectByFoodOrderBySaleNumUp();
    }

    @Override
    public List<Food> selectByFoodOrderBySaleNumDown() {
        return commodityFoodDao.selectByFoodOrderBySaleNumDown();
    }

    @Override
    public List<Food> selectByFoodOrderByScoreDown() {
        return commodityFoodDao.selectByFoodOrderByScoreDown();
    }

    @Override
    public List<Food> selectByFoodOrderByScoreUp() {
        return commodityFoodDao.selectByFoodOrderByScoreUp();
    }

    @Override
    public List<Food> selectFoodOrderBySaleNumDownAndKeyword(String keyword) {
        return commodityFoodDao.selectFoodOrderBySaleNumDownAndKeyword(keyword);
    }

    @Override
    public List<Food> selectFoodOrderBySaleNumUpAndKeyword(String keyword) {
        return commodityFoodDao.selectFoodOrderBySaleNumUpAndKeyword(keyword);
    }

    @Override
    public List<Food> selectByFoodOrderByScoreDownByKeyword(String keyword) {
        return commodityFoodDao.selectByFoodOrderByScoreDownByKeyword(keyword);
    }

    @Override
    public List<Food> selectByFoodOrderByScoreUpByKeyword(String keyword) {
        return commodityFoodDao.selectByFoodOrderByScoreUpByKeyword(keyword);
    }

    @Override
    public List<Food> selectByFoodOrderByPriceDownByKeyword(String keyword) {
        return commodityFoodDao.selectByFoodOrderByPriceDownByKeyword(keyword);
    }

    @Override
    public List<Food> selectByFoodOrderByPriceUpByKeyword(String keyword) {
        return commodityFoodDao.selectByFoodOrderByPriceUpByKeyword(keyword);
    }

    @Override
    public List<String> selectFoodType() {
        return commodityFoodDao.selectFoodType();
    }
}
