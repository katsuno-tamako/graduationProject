package com.ka.store.Service.User.impl;

import com.ka.store.Service.User.UserInfoService;
import com.ka.store.dao.User_infoDao;
import com.ka.store.pojo.user.User_info;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserInfoImpl implements UserInfoService {

    @Resource
    User_infoDao user_infoDao;

    @Override
    public void insertUserInfo(User_info user_info) {
        user_infoDao.insertUserInfo(user_info);
    }

    @Override
    public User_info selectUserInfo(String user_id) {
        return user_infoDao.selectUserInfo(user_id);
    }

    @Override
    public void updateUserInfo(User_info user_info) {
        user_infoDao.updateUserInfo(user_info);
    }

    @Override
    public void insertUserImg(User_info user_info) {
        user_infoDao.insertUserImg(user_info);
    }
}
