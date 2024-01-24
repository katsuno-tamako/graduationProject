package com.ka.store.Controller.User;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.ka.store.Service.User.UserInfoService;
import com.ka.store.Service.User.User_accService;
import com.ka.store.Service.User.User_addressService;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.admin.Admin;
import com.ka.store.pojo.order.Order_info;
import com.ka.store.pojo.user.User_acc;
import com.ka.store.pojo.user.User_address;
import com.ka.store.pojo.user.User_info;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class userController {

    @Resource
    usFunc func;

    @Resource
    User_accService user_accService;

    @Resource
    User_acc user_acc;

    @Resource
    User_info user_info;

    @Resource
    UserInfoService userInfoService;

    @Resource
    User_addressService user_addressService;

    @RequestMapping("/userLogin")
    public String userLogin(@RequestBody User_acc user, HttpSession session){
        System.out.println("登录用户的信息："+user);
        user_acc = user_accService.userLogin(user);
        if(user_acc!=null){
            session.setAttribute("user",user_acc.getUser_id());
            return user_acc.getUser_id();
        }else{
            return "ERROR";
        }
    }

    @RequestMapping("/getUserSession")
    public String getUserSession(HttpSession session){
        try{
            return session.getAttribute("user").toString();
        }catch (Exception e){
            System.out.println(e);
        }
            return "null";
    }

    @RequestMapping("/userLogout")
    public void userLogout(HttpSession session){
        session.removeAttribute("user");
    }

    @RequestMapping("/registerUser")
    public String registerUser(@RequestParam(value = "account",required = false) String account,
                             @RequestParam(value = "password",required = false) String password,
                             @RequestParam(value = "email",required = false) String email,
                             @RequestParam(value = "phone",required = false) String phone){
        user_acc.setAccount(account);
        user_acc.setPassword(password);
        user_acc.setUser_id(account);
        System.out.println(user_acc);
        user_accService.insertUserAcc(user_acc);


        user_info.setEmail(email);
        user_info.setPhone(phone);
        user_info.setUser_id(account);
        System.out.println(user_info);
        userInfoService.insertUserInfo(user_info);

        return user_acc.getUser_id();
    }


    @RequestMapping("/insertAddress")
    public void insertAddress(@RequestBody User_address user_address){
        user_address.setUser_address_id(func.getFN("address"));
        user_addressService.insertAddress(user_address);
    }

    @RequestMapping("/selectUserAddress")
    public List<User_address> selectUserAddress(@RequestParam String user_id){
        return user_addressService.selectUserAddress(user_id);
    }

    @RequestMapping("/deleteAddress")
    public void deleteAddress(@RequestParam int id){
        user_addressService.deleteAddress(id);
    }

    @RequestMapping("/updateAddress")
    public void updateAddress(@RequestBody User_address user_address){
        user_addressService.updateAddress(user_address);
    }

    @RequestMapping("/selectUserInfoById")
    public User_info selectUserInfoById(@RequestParam String user_id){
        return userInfoService.selectUserInfo(user_id);
    }

    @RequestMapping("/updateUserInfo")
    public void updateUserInfo(@RequestBody User_info user_info){
        userInfoService.updateUserInfo(user_info);
    }

    @RequestMapping("/uploadUserImg")
    @CrossOrigin
    public void uploadUserImg(@RequestParam("file") MultipartFile file,@RequestParam("user_id") String user_id){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");

        String fileName = file.getOriginalFilename();
        String fileType=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        String imgPath;
        fileName = "img"+formatter.format(date).toString()+fileType;
        System.out.println(fileName);
        File dest = new File(new File("src\\main\\resources\\static\\images\\userInfo").getAbsolutePath()+ "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try{
            imgPath = "images//userInfo//"+fileName;
            user_info.setImg(imgPath);
            user_info.setUser_id(user_id);
            file.transferTo(dest);
            userInfoService.insertUserImg(user_info);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/selectUserByAccount")
    public Boolean selectUserByAccount(@RequestParam String account){
        return user_accService.selectUserByAccount(account);
    }

    @RequestMapping("/selectUserAccount")
    public String selectUserAccount(@RequestParam String account){
        return user_accService.selectUserAccount(account);
    }

    @RequestMapping("/selectPassword")
    public User_acc selectPassword(HttpSession session){
        user_acc.setUser_id(session.getAttribute("user").toString());
        return  user_accService.selectPassword(user_acc);
    }

    @RequestMapping("/editPassword")
    public void editPassword(@RequestParam String password,HttpSession session){
        user_acc.setUser_id(session.getAttribute("user").toString());
        user_acc.setPassword(password);
        user_accService.editPassword(user_acc);
    }

    @RequestMapping("/findPassEditPass")
    public void findPassEditPass(@RequestParam String user_id,@RequestParam String password){
        user_acc.setPassword(password);
        user_acc.setUser_id(user_id);
        user_accService.editPassword(user_acc);
    }


    @RequestMapping("/getUserNumber")
    public int getUserNumber(){
        return user_accService.userNum();
    }

}
