package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.commodity.clothing.CommodityClothing;
import com.ka.store.pojo.commodity.furniture.CommodityFurniture;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityClothingDao {

    public List<CommodityClothing> selectAllCloth();

    public void insetCloth(CommodityClothing commodityClothing);

    public CommodityClothing selectClothById(String commodity_id);

    public void updateClothById(CommodityClothing commodityClothing);

    public void deleteClothById(String commodity_id);


    public List<CommodityClothing> selectClothByKeyword(String keyword);

    public List<CommodityClothing> selectClothOrderPrice();
    public List<CommodityClothing> selectClothOrderPriceUp();

    public List<CommodityClothing> selectByClothOrderBySaleNumUp();
    public List<CommodityClothing> selectByClothOrderBySaleNumDown();

    public List<CommodityClothing> selectByClothOrderByScoreDown();
    public List<CommodityClothing> selectByClothOrderByScoreUp();

    public List<CommodityClothing> selectClothOrderBySaleNumDownAndKeyword(String keyword);
    public List<CommodityClothing> selectClothOrderBySaleNumUpAndKeyword(String keyword);

    public List<CommodityClothing> selectByClothOrderByScoreDownByKeyword(String keyword);
    public List<CommodityClothing> selectByClothOrderByScoreUpByKeyword(String keyword);

    public List<CommodityClothing> selectByClothOrderByPriceDownByKeyword(String keyword);
    public List<CommodityClothing> selectByClothOrderByPriceUpByKeyword(String keyword);


    public List<String> selectClothBrand();
    public List<String> selectClothSuitable();
    public List<String> selectClothStyle();
    public List<String> selectClothType();


}
