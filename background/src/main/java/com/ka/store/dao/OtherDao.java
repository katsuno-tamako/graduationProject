package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.commodity.other.Other;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherDao {

    public void insertOtherCommodity(Other other);

    public List<Other> selectAllOtherCommodity();

    public Other selectOtherCommodityById(String commodity_id);

    public void updateOtherCommodity(Other other);

    public void deleteOtherCommodityById(String commodity_id);

}
