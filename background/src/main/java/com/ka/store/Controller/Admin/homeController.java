package com.ka.store.Controller.Admin;

import com.ka.store.Service.Admin.HomeImgService;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.admin.Admin;
import com.ka.store.pojo.admin.HomeImg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import javax.annotation.Resource;
import java.io.File;
import java.util.Date;

@RestController
@RequestMapping("/home")
public class homeController {

    @Resource
    HomeImgService homeImgService;

    @Resource
    HomeImg homeImg;

    @RequestMapping("/insertHomeImg")
    @CrossOrigin
    public void insertHomeImg(@RequestParam("file")MultipartFile file){
//        usFunc us = new usFunc();
        usFunc us = new usFunc();
        String imgName = us.getFN("mainImg");
        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        fileName = imgName+fileType;
        System.out.println(fileName);
        String imgPath;
        File dest = new File(new File("src\\main\\resources\\static\\images\\home").getAbsolutePath()+ "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try{
            imgPath = "images//home//"+fileName;
            file.transferTo(dest);
            homeImg.setImg(imgPath);
            homeImgService.insertHomeImg(homeImg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @RequestMapping("/selectCarouselImg")
    public List<HomeImg> selectCarouselImg(Model model){



        return homeImgService.selectAllImg();
    }

    @RequestMapping("/deleteHomeImg")
    public void deleteHomeImg(@RequestParam String img){
        homeImgService.deleteHomeImg(img);
    }

}
