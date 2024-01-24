package com.ka.store.Controller.Admin;
import java.util.List;
import com.ka.store.Service.Admin.AdminService;
import com.ka.store.Service.Merchant.Apply_merchantService;
import com.ka.store.pojo.admin.Admin;
import com.ka.store.pojo.merchant.Apply_merchant;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Resource
    Admin admin;

    @Resource
    AdminService adminService;

    @Resource
    Apply_merchantService apply_merchantService;


    @RequestMapping("/adminLogin")
    public String adminLogin(@RequestBody Admin ad, HttpSession session){
        admin = adminService.adminLogin(ad);
        System.out.println(admin);
        if(admin!=null){
            session.setAttribute("admin",admin);
            return "success";
        }else{
            return "error";
        }
    }


    @RequestMapping("/selectAllApplyMerchant")
    public List<Apply_merchant> selectAllApplyMerchant(){
        return apply_merchantService.selectAllApplyMerchant();
    }

    @RequestMapping("/updateApplyStatus")
    public void updateApplyStatus(@RequestBody Apply_merchant apply_merchant){
        apply_merchant.setStatus("Yes");
        System.out.println(apply_merchant);
        apply_merchantService.updateApplyStatus(apply_merchant);
    }


    @RequestMapping("/logoutAdmin")
    public void logoutAdmin(HttpSession session){
        session.removeAttribute("admin");
    }

    @RequestMapping("/getAdminSession")
    public String getAdminSession(HttpSession session){
        try{
            return session.getAttribute("admin").toString();
        }catch (Exception e){
            System.out.println("null");
        }
            return "NoLog";
    }





}
