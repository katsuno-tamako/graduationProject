package com.ka.store.dao;

import com.ka.store.pojo.admin.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    public Admin adminLogin(Admin admin);


}
