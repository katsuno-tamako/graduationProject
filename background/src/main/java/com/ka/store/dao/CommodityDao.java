package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.food.Food;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDao {

    public void insertCommodity(Commodity commodity);

    public List<Commodity> selectCommodityByMerchant(String merchantID);

    public void updateCommodity(Commodity commodity);

    public void deleteCommodity(String commodity_id);

    public Commodity selectCommodityById(String commodity_id);

    public void updateMainImg(String commodity_id,String path);

    public List<Commodity> selectByCategory(String category);

    public List<Commodity> searchCommodity(String keyword);

    public void insertMainImg(String commodity_id,String main_img);

    public List<String> merchantHaveCategory(String merchant_id);

    public List<Commodity> selectCommodityByMerchantAndCategory(Commodity commodity);

    public String selectMerchantByCommodityId(String commodity_id);

    public List<Commodity> selectCommodityOrderPrice(String keyword);
    public List<Commodity> selectCommodityOrderPriceUp(String keyword);

    public List<Commodity> selectByCommodityOrderBySaleNumUp(String keyword);
    public List<Commodity> selectByCommodityOrderBySaleNumDown(String keyword);

    public List<Commodity> selectByCommodityOrderByScoreDown(String keyword);
    public List<Commodity> selectByCommodityOrderByScoreUp(String keyword);


    public List<Commodity> recommendCommodity();
    public List<Commodity> topGrade();


}
