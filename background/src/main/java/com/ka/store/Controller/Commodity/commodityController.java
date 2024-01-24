package com.ka.store.Controller.Commodity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ka.store.Service.Commodity.CommodityBookService;
import com.ka.store.Service.Commodity.CommodityComputerService;
import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Commodity.ImgService;
import com.ka.store.Service.Commodity.cloth.ClothingService;
import com.ka.store.Service.Commodity.food.FoodService;
import com.ka.store.Service.Commodity.furniture.FurnitureService;
import com.ka.store.Service.Commodity.other.OtherService;
import com.ka.store.Service.Commodity.phone.PhoneService;
import com.ka.store.config.usFunc;
import com.ka.store.dao.CommodityDao;
import com.ka.store.dao.Commodity_categories_booksDao;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.CommodityImg;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_books;
import com.ka.store.pojo.commodity.phone.CommodityPhone;
import com.ka.store.pojo.merchant.Merchant_lo;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.soap.MimeHeaders;
@CrossOrigin
@RestController
public class commodityController implements Runnable{

    @Resource
    usFunc func;

    @Resource
    Commodity_categories_booksDao commodity_categories_booksDao;

    @Resource
    CommodityDao commodityDao;

    @Resource
    ImgService imgService;

    @Resource
    CommodityImg commodityImg;

    @Resource
    CommodityService commodityService;

    @Resource
    Commodity commodity;

    @RequestMapping("/selectBookByName")
    public Commodity_categories_books selectBookByName(){
        return commodity_categories_booksDao.selectCommodityBooksById("将死未死的青");
    }


    @RequestMapping("/selectCommodityByMerchant")
    public List<Commodity> selectCommodityByMerchant(@RequestParam String merchantId){
        return commodityDao.selectCommodityByMerchant(merchantId);
    }

    @RequestMapping("/selectCommoditiesByMID")
    public List<Commodity> selectCommoditiesByMID(HttpSession session){
        String merchant_id =  session.getAttribute("merchantId").toString();
        return commodityService.selectCommodityByMerchant(merchant_id);
    }

    private Thread thread;

    @Override
    public void run() {

    }

    @PostMapping("/uploadCommodity")
    @CrossOrigin
    public synchronized String uploadCommodity(@RequestParam(value="commodity_id") String commodity_id,@RequestParam("file") MultipartFile file ,HttpServletRequest request) throws IOException {
        System.out.println(file);
        String fileName = file.getOriginalFilename();
        String imgPath;
        String fileType=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        String s = fileName;
        String result = s.substring(0,3);
        System.out.println(result);
        fileName = func.getFN("img")+result+fileType;
        imgPath = "images//commodity//"+fileName;
        System.out.println("传入图片名："+fileName);
        commodityImg.setCommodity_id(commodity_id);
        commodityImg.setPath(imgPath);
        System.out.println("font:"+commodityImg);
        imgService.insertCommodityImg(commodityImg);
        System.out.println("after"+commodityImg);
        try {
            file.transferTo(new File(new File("src\\main\\resources\\static\\images\\commodity").getAbsolutePath()+ "/" + fileName));
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }



    }


    @RequestMapping("/getImg")
    public List<CommodityImg> getImg(@RequestParam(value="commodity_id") String commodity_id) throws Exception{
        System.out.println(commodity_id);
        return imgService.selectImgByCommodityId(commodity_id);
    }

    @RequestMapping("/deleteImgByPath")
    public void deleteImgByPath(@RequestParam(value = "url") String url){
        imgService.deleteImgByPath(url);
    }

        @RequestMapping("/deleteImgArray")
    public void deleteImgArray(@RequestBody CommodityImg[] commodityImg){
        System.out.println(commodityImg);
        for(CommodityImg c : commodityImg){
            System.out.println(c);
            imgService.deleteImgByPath(c.getPath());
        }
    }

    @RequestMapping("/selectCommodityById")
    public Commodity selectCommodityById(@RequestParam(value="commodity_id") String commodity_id){
        return commodityService.selectCommodityById(commodity_id);
    }

    @RequestMapping("/updateMainImg")
    public void updateMainImg(@RequestParam(value="commodity_id") String commodity_id,@RequestParam("path")String path){
        commodityService.updateMainImg(commodity_id,path);
    }

    @RequestMapping("/selectCommodityByCategory")
    public List<Commodity> selectCommodityByCategory(@RequestParam String category){
        return commodityService.selectByCategory(category);
    }

    @RequestMapping("/editCommodityInfo")
    public void editCommodityInfo(@RequestBody Commodity commodity){
        commodityService.updateCommodity(commodity);
    }

    @RequestMapping("/searchCommodity")
    public List<Commodity> searchCommodity(@RequestParam String keyword){
        return commodityService.searchCommodity(keyword);
    }

    @Resource
    CommodityBookService commodityBookService;

    @Resource
    CommodityComputerService commodityComputerService;

    @Resource
    ClothingService clothingService;

    @Resource
    PhoneService phoneService;

    @Resource
    FoodService foodService;

    @Resource
    OtherService otherService;

    @Resource
    FurnitureService furnitureService;

    @RequestMapping("/delCom")
    public void delCom(@RequestBody Commodity commodity){
        System.out.println(commodity);
        commodityService.deleteCommodity(commodity.getCommodity_id());

        if(commodity.getCategory().equals("图书")){
            commodityBookService.deleteBookCommodity(commodity.getCommodity_id());
        }
        if(commodity.getCategory().equals("手机")){phoneService.deletePhoneInfo(commodity.getCommodity_id());}
        if(commodity.getCategory().equals("服装")){clothingService.deleteClothById(commodity.getCommodity_id());}
        if(commodity.getCategory().equals("电脑")){commodityComputerService.deleteComputerById(commodity.getCommodity_id());}
        if(commodity.getCategory().equals("食品")){foodService.deleteFoodById(commodity.getCommodity_id());}
        if(commodity.getCategory().equals("其他")){otherService.deleteOtherCommodityById(commodity.getCommodity_id());}
        if(commodity.getCategory().equals("家具")){furnitureService.deleteFurnitureById(commodity.getCommodity_id());}

    }

    @RequestMapping("/selectCommodityByMerchantAndCategory")
    public List<Commodity> selectCommodityByMerchantAndCategory(@RequestParam String category,HttpSession session){
        commodity.setCategory(category);
        commodity.setMerchant_id(session.getAttribute("merchantId").toString());
        List<Commodity> commodityList = commodityService.selectCommodityByMerchantAndCategory(commodity);
        return commodityList;
    }

    @RequestMapping("/updateCommodityImage")
    @CrossOrigin
    public void updateCommodityImage(@RequestParam("file") MultipartFile file ,@RequestParam(value="commodity_id") String commodity_id){
        System.out.println("接收文件");
        System.out.println(file);
    }


    @RequestMapping("/selCommodity")
    public List<Commodity> selCommodity(@RequestParam String keyword,@RequestParam String sort){
        System.out.println("电脑排序--关键字："+keyword+"；排序方式："+sort);
            if(sort.equals("no")){
                return commodityService.searchCommodity(keyword);
            }else{
                if(sort.equals("up")){
                    return  commodityService.selectCommodityOrderPriceUp(keyword);
                }else if(sort.equals("down")){
                    return commodityService.selectCommodityOrderPrice(keyword);
                }else if(sort.equals("nUp")){
                    return commodityService.selectByCommodityOrderBySaleNumUp(keyword);
                }else if(sort.equals("nDown")){
                    return commodityService.selectByCommodityOrderBySaleNumDown(keyword);
                }else if (sort.equals("sDown")){
                    return commodityService.selectByCommodityOrderByScoreDown(keyword);
                }else if(sort.equals("sUp")){
                    return commodityService.selectByCommodityOrderByScoreUp(keyword);
                }
            }

        return null;
    }


    @RequestMapping("/recommendCommodity")
    public List<Commodity> recommendCommodity(){
        return commodityService.recommendCommodity();
    }

    @RequestMapping("/topGrade")
    public List<Commodity> topGrade(){
        return commodityService.topGrade();
    }



}
