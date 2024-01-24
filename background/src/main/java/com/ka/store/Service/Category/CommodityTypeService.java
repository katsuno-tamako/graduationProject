package com.ka.store.Service.Category;

import com.ka.store.pojo.commodity.type.CommodityType.Commodity_type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommodityTypeService {

    public List<Commodity_type> selectAllCommodityType();

    public void insertCommodityType(Commodity_type commodity_type);

    public void deleteCommodityId(Commodity_type commodity_type);

}
