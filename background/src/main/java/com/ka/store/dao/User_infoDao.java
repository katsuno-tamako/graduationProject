package com.ka.store.dao;
import java.util.List;
import com.ka.store.pojo.user.User_info;
import org.springframework.stereotype.Repository;

@Repository
public interface User_infoDao {

    public void insertUserInfo(User_info user_info);

    public User_info selectUserInfo(String user_id);

    public void updateUserInfo(User_info user_info);

    public void insertUserImg(User_info user_info);

}
