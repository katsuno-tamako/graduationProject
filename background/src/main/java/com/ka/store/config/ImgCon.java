package com.ka.store.config;

import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Commodity.ImgService;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.CommodityImg;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
@Component
public class ImgCon {

    @Resource
    Commodity commodity;

    @Resource
    CommodityService commodityService;

    @Resource
    CommodityImg commodityImg;

    @Resource
    usFunc func;

    @Resource
    ImgService imgService;


    public void insertImg(MultipartFile file,String commodity_id){
        System.out.println(file);
        String fileName = file.getOriginalFilename();
        String fileType=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        String imgPath;
        String fileN = func.getFN("img");
        fileName = fileN+fileType;
        System.out.println(fileName);
        File dest = new File(new File("src\\main\\resources\\static\\images\\commodity").getAbsolutePath()+ "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try{
            imgPath = "images//commodity//"+fileName;
            commodity.setCommodity_id(commodity_id);
            commodity.setMain_img(imgPath);
            file.transferTo(dest);
            commodityService.updateMainImg(commodity_id,imgPath);
            commodityImg.setPath(imgPath);
            commodityImg.setCommodity_id(commodity_id);
            System.out.println(commodityImg);
            imgService.insertCommodityImg(commodityImg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
