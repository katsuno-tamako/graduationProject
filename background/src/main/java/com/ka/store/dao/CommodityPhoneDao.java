package com.ka.store.dao;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_computer;
import com.ka.store.pojo.commodity.phone.CommodityPhone;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommodityPhoneDao {

    public void insertPhoneInfo(CommodityPhone commodityPhone);

    public CommodityPhone selectPhoneById(String commodity_id);

    public void updatePhoneInfo(CommodityPhone commodityPhone);

    public void deletePhoneInfo(String commodity_id);

    public List<CommodityPhone> getPopPhone();

    public List<CommodityPhone> selectAllPhone();

    public List<CommodityPhone> selectPhoneByBrand(String brand);

    public List<CommodityPhone> selectByPhoneKeyword(String keyword);


    public List<CommodityPhone> selectPhoneOrderPrice();
    public List<CommodityPhone> selectPhoneOrderPriceUp();

    public List<CommodityPhone> selectByPhoneOrderBySaleNumUp();
    public List<CommodityPhone> selectByPhoneOrderBySaleNumDown();

    public List<CommodityPhone> selectByPhoneOrderByScoreDown();
    public List<CommodityPhone> selectByPhoneOrderByScoreUp();

    public List<CommodityPhone> selectPhoneOrderBySaleNumDownAndKeyword(String keyword);
    public List<CommodityPhone> selectPhoneOrderBySaleNumUpAndKeyword(String keyword);

    public List<CommodityPhone> selectByPhoneOrderByScoreDownByKeyword(String keyword);
    public List<CommodityPhone> selectByPhoneOrderByScoreUpByKeyword(String keyword);

    public List<CommodityPhone> selectByPhoneOrderByPriceDownByKeyword(String keyword);
    public List<CommodityPhone> selectByPhoneOrderByPriceUpByKeyword(String keyword);

    public List<String> selectPhoneBrand();

}
