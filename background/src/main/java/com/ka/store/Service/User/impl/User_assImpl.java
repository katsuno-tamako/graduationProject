package com.ka.store.Service.User.impl;

import com.ka.store.Service.User.User_accService;
import com.ka.store.dao.User_accDao;
import com.ka.store.pojo.user.User_acc;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class User_assImpl implements User_accService {

    @Resource
    User_accDao user_accDao;

    @Resource
    User_acc user_acc;

    @Override
    public User_acc userLogin(User_acc user) {
        user_acc = user_accDao.userLogin(user);

        return user_accDao.userLogin(user);
    }

    @Override
    public void insertUserAcc(User_acc user_acc) {
        user_accDao.insertUserAcc(user_acc);
    }

    @Override
    public Boolean selectUserByAccount(String account) {
        user_acc = user_accDao.selectUserByAccount(account);
        if(user_acc==null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String selectUserAccount(String account) {
        if(user_accDao.selectUserAccount(account)==null){
            return "ok";
        }else {
            return "no";
        }
    }

    @Override
    public User_acc selectPassword(User_acc user_acc) {
        return user_accDao.selectPassword(user_acc);
    }

    @Override
    public void editPassword(User_acc user_acc) {
        user_accDao.editPassword(user_acc);
    }

    @Override
    public int userNum() {
        return user_accDao.userNum();
    }
}
