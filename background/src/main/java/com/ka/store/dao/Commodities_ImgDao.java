package com.ka.store.dao;

import java.util.List;
import com.ka.store.pojo.commodity.CommodityImg;
import org.springframework.stereotype.Repository;

@Repository
public interface Commodities_ImgDao {

    public void insertCommodityImg(CommodityImg commodityImg);

    public List<CommodityImg> selectImgByCommodityId(String commodity_id);

    public void deleteAllImg(String commodity_id);

    public void deleteImgByPath(String url);

}
