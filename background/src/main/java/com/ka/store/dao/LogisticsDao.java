package com.ka.store.dao;
import java.util.List;

import com.ka.store.pojo.logistics.Logistics;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsDao {

    public List<Logistics> selectAllLogistics();

    public void insertLogistics(Logistics logistics);

    public void updateLogisticsStatus(Logistics logistics);

}
