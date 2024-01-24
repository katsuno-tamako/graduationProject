package com.ka.store.Service.Category.impl;

import com.ka.store.Service.Category.CommodityTypeService;
import com.ka.store.dao.Commodity_typeDao;
import com.ka.store.pojo.commodity.type.CommodityType.Commodity_type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CommodityTypeImpl implements CommodityTypeService {

    @Resource
    Commodity_typeDao commodity_typeDao;

    @Override
    public List<Commodity_type> selectAllCommodityType() {
        return commodity_typeDao.selectAllCommodityType();
    }

    @Override
    public void insertCommodityType(Commodity_type commodity_type) {
        commodity_typeDao.insertCommodityType(commodity_type);
    }

    @Override
    public void deleteCommodityId(Commodity_type commodity_type) {
        commodity_typeDao.deleteCommodityId(commodity_type);
    }
}
