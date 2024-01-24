package com.ka.store.dao;

import com.ka.store.pojo.user.User_acc;
import org.springframework.stereotype.Repository;

@Repository
public interface User_accDao {

    public User_acc userLogin(User_acc user_acc);

    public void insertUserAcc(User_acc user_acc);

    public User_acc selectUserByAccount(String account);

    public User_acc selectUserAccount(String account);

    public User_acc selectPassword(User_acc user_acc);

    public void editPassword(User_acc user_acc);

    public int userNum();

}
