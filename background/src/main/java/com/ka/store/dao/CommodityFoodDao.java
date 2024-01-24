package com.ka.store.dao;

import com.ka.store.pojo.commodity.food.Food;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CommodityFoodDao {

    public List<Food> selectAllFood();

    public void insertFoodInfo(Food food);

    public void updateFoodInfo(Food food);

    public Food selectFoodById(String commodity_id);

    public void deleteFoodById(String commodity_id);

    public List<Food> selectFoodByKeyword(String keyword);

    public List<Food> selectFoodOrderPrice();
    public List<Food> selectFoodOrderPriceUp();

    public List<Food> selectByFoodOrderBySaleNumUp();
    public List<Food> selectByFoodOrderBySaleNumDown();

    public List<Food> selectByFoodOrderByScoreDown();
    public List<Food> selectByFoodOrderByScoreUp();

    public List<Food> selectFoodOrderBySaleNumDownAndKeyword(String keyword);
    public List<Food> selectFoodOrderBySaleNumUpAndKeyword(String keyword);

    public List<Food> selectByFoodOrderByScoreDownByKeyword(String keyword);
    public List<Food> selectByFoodOrderByScoreUpByKeyword(String keyword);

    public List<Food> selectByFoodOrderByPriceDownByKeyword(String keyword);
    public List<Food> selectByFoodOrderByPriceUpByKeyword(String keyword);


    public List<String> selectFoodType();

}
