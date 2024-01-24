package com.ka.store.Service.Commodity;

import java.util.List;
import com.ka.store.pojo.commodity.CommodityImg;
import org.springframework.stereotype.Service;

@Service
public interface ImgService {

    public void insertCommodityImg(CommodityImg commodityImg);

    public List<CommodityImg> selectImgByCommodityId(String commodity_Id);

    public void deleteAllCommodityImg(String commodity_id);

    public void deleteImgByPath(String url);

}
