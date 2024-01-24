package com.ka.store.Service.Admin;

import com.ka.store.pojo.admin.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    public Admin adminLogin(Admin admin);



}
