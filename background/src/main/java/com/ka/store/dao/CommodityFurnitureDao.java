package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.commodity.furniture.CommodityFurniture;
import com.ka.store.pojo.commodity.phone.CommodityPhone;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityFurnitureDao {

    public List<CommodityFurniture> selectAllFurniture();

    public void insertFurniture(CommodityFurniture commodityFurniture);

    public void updateFurnitureById(CommodityFurniture commodityFurniture);

    public void deleteFurnitureById(String commodity_id);

    public CommodityFurniture selectFurnitureById(String commodity_id);




    public List<CommodityFurniture> selectFurnitureByKeyword(String keyword);

    public List<CommodityFurniture> selectFurnitureOrderPrice();
    public List<CommodityFurniture> selectFurnitureOrderPriceUp();

    public List<CommodityFurniture> selectByFurnitureOrderBySaleNumUp();
    public List<CommodityFurniture> selectByFurnitureOrderBySaleNumDown();

    public List<CommodityFurniture> selectByFurnitureOrderByScoreDown();
    public List<CommodityFurniture> selectByFurnitureOrderByScoreUp();

    public List<CommodityFurniture> selectFurnitureOrderBySaleNumDownAndKeyword(String keyword);
    public List<CommodityFurniture> selectFurnitureOrderBySaleNumUpAndKeyword(String keyword);

    public List<CommodityFurniture> selectByFurnitureOrderByScoreDownByKeyword(String keyword);
    public List<CommodityFurniture> selectByFurnitureOrderByScoreUpByKeyword(String keyword);

    public List<CommodityFurniture> selectByFurnitureOrderByPriceDownByKeyword(String keyword);
    public List<CommodityFurniture> selectByFurnitureOrderByPriceUpByKeyword(String keyword);

    public List<String> selectFurnitureType();
    public List<String> selectFurnitureStyle();
    public List<String> selectFurnitureBrand();


}
