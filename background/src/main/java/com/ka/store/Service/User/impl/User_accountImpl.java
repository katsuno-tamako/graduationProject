package com.ka.store.Service.User.impl;

import com.ka.store.Service.User.User_addressService;
import com.ka.store.dao.User_addressDao;
import com.ka.store.pojo.user.User_address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class User_accountImpl implements User_addressService {

    @Resource
    User_addressDao user_addressDao;

    @Override
    public void insertAddress(User_address user_address) {
        user_addressDao.insertAddress(user_address);
    }

    @Override
    public List<User_address> selectUserAddress(String user_id) {
        return user_addressDao.selectAddressByUser(user_id);
    }

    @Override
    public void deleteAddress(int id) {
        user_addressDao.deleteAddress(id);
    }

    @Override
    public void updateAddress(User_address user_address) {
        user_addressDao.updateAddress(user_address);
    }
}
