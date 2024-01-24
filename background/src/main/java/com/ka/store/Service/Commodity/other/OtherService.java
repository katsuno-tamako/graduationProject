package com.ka.store.Service.Commodity.other;

import com.ka.store.pojo.commodity.other.Other;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OtherService {

    public void insertOtherCommodity(Other other);

    public List<Other> selectAllOtherCommodity();

    public Other selectOtherCommodityById(String commodity_id);

    public void updateOtherCommodity(Other other);

    public void deleteOtherCommodityById(String commodity_id);

}
