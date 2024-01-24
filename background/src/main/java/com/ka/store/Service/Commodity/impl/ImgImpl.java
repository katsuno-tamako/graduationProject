package com.ka.store.Service.Commodity.impl;

import com.ka.store.Service.Commodity.ImgService;
import com.ka.store.dao.Commodities_ImgDao;
import com.ka.store.dao.CommodityDao;
import com.ka.store.pojo.commodity.CommodityImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ImgImpl implements ImgService {

    @Resource
    Commodities_ImgDao commodities_imgDao;

    @Override
    public void insertCommodityImg(CommodityImg commodityImg) {
        System.out.println("Service:"+commodityImg);
        commodities_imgDao.insertCommodityImg(commodityImg);
    }

    @Override
    public List<CommodityImg> selectImgByCommodityId(String commodity_Id) {
        return commodities_imgDao.selectImgByCommodityId(commodity_Id);
    }

    @Override
    public void deleteAllCommodityImg(String commodity_id) {
        commodities_imgDao.deleteAllImg(commodity_id);
    }

    @Override
    public void deleteImgByPath(String url) {
        commodities_imgDao.deleteImgByPath(url);
    }
}
