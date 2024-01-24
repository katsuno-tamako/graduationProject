package com.ka.store.Service.Logistics.impl;

import com.ka.store.Service.Logistics.LogisticsService;
import com.ka.store.config.usFunc;
import com.ka.store.dao.LogisticsDao;
import com.ka.store.pojo.logistics.Logistics;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class LogisticsImpl implements LogisticsService {

    @Resource
    LogisticsDao logisticsDao;

    @Resource
    usFunc func;

    @Override
    public List<Logistics> selectAllLogistics() {
        return logisticsDao.selectAllLogistics();
    }

    @Override
    public void insertLogistics(Logistics logistics) {

        logisticsDao.insertLogistics(logistics);
    }

    @Override
    public void updateLogisticsStatus(Logistics logistics) {
        logisticsDao.updateLogisticsStatus(logistics);
    }
}
