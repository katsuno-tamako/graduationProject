package com.ka.store.Service.sales;

import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Sales_commodityService {

    public List<Sales_commodity> selectSalesCommodity();

    public void increaseSalesNum(Sales_commodity sales_commodity);

    public void insertCommoditySalesInfo(Sales_commodity commodity);

    public void updateAveScore(Sales_commodity sales_commodity);

    public String selectAveByCommodityId(Sales_commodity sales_commodity);

    public void insertAveScore(Sales_commodity sales_commodity);




}
