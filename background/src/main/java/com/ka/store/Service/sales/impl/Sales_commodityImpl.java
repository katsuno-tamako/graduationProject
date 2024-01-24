package com.ka.store.Service.sales.impl;

import com.ka.store.Service.sales.Sales_commodityService;
import com.ka.store.dao.Sales_commodityDao;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Sales_commodityImpl implements Sales_commodityService {

    @Resource
    Sales_commodityDao sales_commodityDao;

    @Override
    public List<Sales_commodity> selectSalesCommodity() {
        return sales_commodityDao.selectSalesCommodity();
    }

    @Override
    public void increaseSalesNum(Sales_commodity sales_commodity) {
        sales_commodityDao.increaseSalesNum(sales_commodity);
    }

    @Override
    public void insertCommoditySalesInfo(Sales_commodity commodity) {
        sales_commodityDao.insertCommoditySalesInfo(commodity);
    }

    @Override
    public void updateAveScore(Sales_commodity sales_commodity) {
        sales_commodityDao.updateAveScore(sales_commodity);
    }

    @Override
    public String selectAveByCommodityId(Sales_commodity sales_commodity) {
        return sales_commodityDao.selectAveByCommodityId(sales_commodity);
    }

    @Override
    public void insertAveScore(Sales_commodity sales_commodity) {
        sales_commodityDao.insertAveScore(sales_commodity);
    }
}
