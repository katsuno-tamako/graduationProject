package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.stereotype.Repository;

@Repository
public interface Sales_commodityDao {

    public List<Sales_commodity> selectSalesCommodity();

    public void increaseSalesNum(Sales_commodity sales_commodity);

    public void insertCommoditySalesInfo(Sales_commodity commodity);

    public void updateAveScore(Sales_commodity sales_commodity);

    public String selectAveByCommodityId(Sales_commodity sales_commodity);

    public void insertAveScore(Sales_commodity sales_commodity);

}
