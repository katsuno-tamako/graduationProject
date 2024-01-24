package com.ka.store.Controller.Commodity;

import com.ka.store.Service.Commodity.CommodityPhoneService;
import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Commodity.ImgService;
import com.ka.store.Service.Commodity.phone.PhoneService;
import com.ka.store.Service.sales.Sales_commodityService;
import com.ka.store.config.ImgCon;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_phone;
import com.ka.store.pojo.commodity.phone.CommodityPhone;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;

@RestController
@RequestMapping("/phone")
public class phoneController {

    @Resource
    usFunc fun;


    @Resource
    Commodity commodity;

    @Resource
    CommodityService commodityService;

    @Resource
    ImgService imgService;

    @Resource
    CommodityPhoneService commodityPhoneService;

    @Resource
    PhoneService phoneService;

    @Resource
    Sales_commodity sales_commodity;

    @Resource
    Sales_commodityService sales_commodityService;

    @RequestMapping("/insertPhone")
    public String insertPhone(@RequestBody CommodityPhone phone, HttpSession session){
        phone.setCommodity_id(fun.getFN("phone"));
//        commodity.setCategory("手机");
//        commodity.setPrice(phone.getPhone_price());
//        commodity.setName(phone.getPhone_name());
//        commodity.setCommodity_id(phone.getCommodity_id());
//        commodity.setMerchant_id(session.getAttribute("merchantId").toString());

        phone.getCommodity().setCategory("手机");
        phone.getCommodity().setPrice(phone.getPrice());
        phone.getCommodity().setMerchant_id(session.getAttribute("merchantId").toString());
        phone.getCommodity().setCommodity_id(phone.getCommodity_id());
        phone.getCommodity().setPrice(phone.getPrice());
        phone.getCommodity().setName(phone.getCommodity_name());

        sales_commodity.setAve_grade("no");
        sales_commodity.setCommodity_id(phone.getCommodity_id());
        sales_commodity.setSales_num(0);
        System.out.println(sales_commodity);
        sales_commodityService.insertCommoditySalesInfo(sales_commodity);

//        phone.setCommodity(commodity);
        phoneService.insertPhoneInfo(phone);
        System.out.println(phone);
        return phone.getCommodity_id();
    }

    @Resource
    ImgCon imgCon;

    @RequestMapping("/receivePhoneImage")
    @CrossOrigin
    public synchronized void receivePhoneImage(@RequestParam("file")MultipartFile file,@RequestParam(value="commodity_id") String commodity_id){
        imgCon.insertImg(file,commodity_id);
    }

//    @RequestMapping("/selectPhoneById")
//    public Commodity_categories_phone selectPhoneById(@RequestParam(value="commodity_id") String commodity_id){
//        return  commodityPhoneService.selectPhoneById(commodity_id);
//    }

    @RequestMapping("/receivePhoneImg")
    @CrossOrigin
    public void receivePhoneImg(@RequestParam("file") MultipartFile file ,@RequestParam(value="commodity_id") String commodity_id){
        System.out.println("receivePhoneImg");
        String fileName = file.getOriginalFilename();
        String fileType=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        String imgPath;
        String fileN = fun.getFN("phoneImg");
        fileName = fileN+fileType;
        System.out.println(fileName);
        File dest = new File(new File("src\\main\\resources\\static\\images\\commodity").getAbsolutePath()+ "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try{
            imgPath = "images//commodity//phone//"+fileName;
            commodity.setCommodity_id(commodity_id);
            commodity.setMain_img(imgPath);
            file.transferTo(dest);
            System.out.println("commodity_id:"+commodity_id);
            System.out.println("---");
            System.out.println("path:"+imgPath);
            System.out.println("---");
            commodityService.updateMainImg(commodity_id,imgPath);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping("/receivePhoneInfo")
    public String receivePhoneInfo(@RequestBody CommodityPhone commodityPhone,HttpSession session){
        System.out.println("receivePhoneInfo");
        String commodity_id = fun.getFN("phone");
        commodityPhone.setCommodity_id(commodity_id);
        commodity.setCommodity_id(commodity_id);
        commodity.setName(commodityPhone.getCommodity_name());
        commodity.setCategory("手机");
        commodity.setMerchant_id(session.getAttribute("merchantId").toString());
        commodity.setPrice(commodityPhone.getPrice());
        commodity.setMain_img("-");
        commodityPhone.setCommodity(commodity);
        session.setAttribute("cid",commodity_id);
        phoneService.insertPhoneInfo(commodityPhone);
        return commodity_id;
    }

    @RequestMapping("/selectPhoneById")
    public CommodityPhone selectPhoneById(@RequestParam String commodity_id){
        System.out.println("selectPhoneById");
        return phoneService.selectPhoneById(commodity_id);
    }

    @RequestMapping("/updatePhoneInfo")
    public void updatePhoneInfo(@RequestBody CommodityPhone commodityPhone){
        commodityPhone.getCommodity().setCommodity_id(commodityPhone.getCommodity_id());
        commodityPhone.getCommodity().setPrice(commodityPhone.getPrice());
        commodityPhone.getCommodity().setName(commodityPhone.getCommodity_name());
        phoneService.updatePhoneInfo(commodityPhone);
    }

    @RequestMapping("/deletePhoneInfo")
    public void deletePhoneInfo(@RequestParam String commodity_id){
        phoneService.deletePhoneInfo(commodity_id);
        commodityService.deleteCommodity(commodity_id);
    }

    @RequestMapping("/getPopPhone")
    public List<CommodityPhone> getPopPhone(){
        return phoneService.getPopPhone();
    }

    @RequestMapping("/selectAllPhone")
    public List<CommodityPhone> selectAllPhone(){
        return phoneService.selectAllPhone();
    }

    @RequestMapping("/selectPhoneByBand")
    public List<CommodityPhone> selectPhoneByBand(@RequestParam String brand){
        System.out.println(phoneService.selectPhoneByBrand(brand));
        return phoneService.selectPhoneByBrand(brand);
    }

    @RequestMapping("/selPhone")
    public List<CommodityPhone>selPhone(@RequestParam String keyword,@RequestParam String sort){
        System.out.println("图书排序--关键字："+keyword+";排序方式："+sort);
        if(keyword.equals("no key")){
            if(sort.equals("no")){
                return phoneService.selectAllPhone();
            }else{
                if(sort.equals("up")){
                    return  phoneService.selectPhoneOrderPriceUp();
                }else if(sort.equals("down")){
                    return phoneService.selectPhoneOrderPrice();
                }else if(sort.equals("nUp")){
                    return phoneService.selectByPhoneOrderBySaleNumUp();
                }else if(sort.equals("nDown")){
                    return phoneService.selectByPhoneOrderBySaleNumDown();
                }else if (sort.equals("sDown")){
                    return phoneService.selectByPhoneOrderByScoreDown();
                }else if(sort.equals("sUp")){
                    return phoneService.selectByPhoneOrderByScoreUp();
                }
            }
        }else{
            if(sort.equals("no")){
                return phoneService.selectByPhoneKeyword(keyword);
            }else{
                if(sort.equals("up")){
                    return  phoneService.selectByPhoneOrderByPriceUpByKeyword(keyword);
                }else if(sort.equals("down")){
                    return phoneService.selectByPhoneOrderByPriceDownByKeyword(keyword);
                }else if(sort.equals("nUp")){
                    return phoneService.selectPhoneOrderBySaleNumUpAndKeyword(keyword);
                }else if(sort.equals("nDown")){
                    return phoneService.selectPhoneOrderBySaleNumDownAndKeyword(keyword);
                }else if(sort.equals("sDown")){
                    return phoneService.selectByPhoneOrderByScoreDownByKeyword(keyword);
                }else if(sort.equals("sUp")){
                    return phoneService.selectByPhoneOrderByScoreUpByKeyword(keyword);
                }
            }
        }
        return null;
    }


    @RequestMapping("/selectPhoneBrand")
    public List<String> selectPhoneBrand(){
        return phoneService.selectPhoneBrand();
    }

}
