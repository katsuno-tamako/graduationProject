package com.ka.store.Service.User;

import com.ka.store.dao.User_accDao;
import com.ka.store.pojo.user.User_acc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public interface User_accService {

    public User_acc userLogin(User_acc user_acc);

    public void insertUserAcc(User_acc user_acc);

    public Boolean selectUserByAccount(String account);

    public String selectUserAccount(String account);

    public User_acc selectPassword(User_acc user_acc);

    public void editPassword(User_acc user_acc);

    public int userNum();


}
