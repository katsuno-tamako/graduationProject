package com.ka.store.Service.Admin.impl;

import com.ka.store.Service.Admin.AdminService;
import com.ka.store.dao.AdminDao;
import com.ka.store.pojo.admin.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminImpl implements AdminService {

   @Resource
   AdminDao adminDao;

    @Override
    public Admin adminLogin(Admin admin) {
        return adminDao.adminLogin(admin);
    }


}
