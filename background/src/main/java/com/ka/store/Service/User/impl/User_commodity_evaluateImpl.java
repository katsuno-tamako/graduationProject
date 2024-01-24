package com.ka.store.Service.User.impl;

import com.ka.store.Service.User.User_commodity_evaluateService;
import com.ka.store.dao.User_commodity_evaluateDao;
import com.ka.store.pojo.comment.User_commodity_evaluate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class User_commodity_evaluateImpl implements User_commodity_evaluateService {

    @Resource
    User_commodity_evaluateDao user_commodity_evaluateDao;

    @Override
    public void insertUCInfo(User_commodity_evaluate user_commodity_evaluate) {
        user_commodity_evaluateDao.insertUCInfo(user_commodity_evaluate);
    }
}
