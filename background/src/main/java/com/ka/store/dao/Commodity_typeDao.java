package com.ka.store.dao;

import com.ka.store.pojo.commodity.type.CommodityType.Commodity_type;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface Commodity_typeDao {

    public List<Commodity_type> selectAllCommodityType();

    public void insertCommodityType(Commodity_type commodity_type);

    public void deleteCommodityId(Commodity_type commodity_type);

}
