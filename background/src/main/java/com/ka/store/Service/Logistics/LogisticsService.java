package com.ka.store.Service.Logistics;

import com.ka.store.pojo.logistics.Logistics;
import com.ka.store.pojo.order.Order_main;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogisticsService {

    public List<Logistics> selectAllLogistics();

    public void insertLogistics(Logistics logistics);

    public void updateLogisticsStatus(Logistics logistics);




}
