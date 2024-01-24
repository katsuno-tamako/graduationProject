package com.ka.store.Controller.Commodity;
import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Commodity.cloth.ClothingService;
import com.ka.store.Service.sales.Sales_commodityService;
import com.ka.store.config.ImgCon;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.clothing.CommodityClothing;
import com.ka.store.pojo.commodity.furniture.CommodityFurniture;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
@RestController
@RequestMapping("/cloth")
public class clothingController {

    @Resource
    ClothingService clothingService;

    @Resource
    Commodity commodity;

    @Resource
    CommodityService commodityService;

    @Resource
    usFunc func;

    @Resource
    ImgCon imgCon;

    @Resource
    Sales_commodity sales_commodity;

    @Resource
    Sales_commodityService sales_commodityService;

    @RequestMapping("/selectAllClothing")
    public List<CommodityClothing> selectAllClothing(){
        return clothingService.selectAllClothing();
    }

    @RequestMapping("/insertCloth")
    public String insertCloth(@RequestBody CommodityClothing commodityClothing, HttpSession session){
        commodityClothing.setCommodity_id(func.getFN("cloth"));
        commodityClothing.getCommodity().setMerchant_id(session.getAttribute("merchantId").toString());
        commodityClothing.getCommodity().setCommodity_id(commodityClothing.getCommodity_id());
        commodityClothing.getCommodity().setPrice(commodityClothing.getPrice());
        commodityClothing.getCommodity().setCategory("服装");
        commodityClothing.getCommodity().setName(commodityClothing.getCommodity_name());
        clothingService.insertCloth(commodityClothing);
        sales_commodity.setAve_grade("no");
        sales_commodity.setCommodity_id(commodityClothing.getCommodity_id());
        sales_commodity.setSales_num(0);
        System.out.println(sales_commodity);
        sales_commodityService.insertCommoditySalesInfo(sales_commodity);
        return commodityClothing.getCommodity_id();
    }


    @RequestMapping("/receiveClothImage")
    @CrossOrigin
    public synchronized void receiveClothImage(@RequestParam("file") MultipartFile file, @RequestParam(value="commodity_id") String commodity_id){
        imgCon.insertImg(file,commodity_id);
    }

    @RequestMapping("/selectClothById")
    public  CommodityClothing selectClothById(@RequestParam String commodity_id ){
        return clothingService.selectClothById(commodity_id);
    }

    @RequestMapping("/updateCloth")
    public void updateCloth(@RequestBody CommodityClothing commodityClothing){
        commodityClothing.getCommodity().setCommodity_id(commodityClothing.getCommodity_id());
        commodityClothing.getCommodity().setName(commodityClothing.getCommodity_name());
        commodityClothing.getCommodity().setPrice(commodityClothing.getPrice());
        clothingService.updateClothById(commodityClothing);
    }

    @RequestMapping("/deleteClothById")
    public void deleteClothById(@RequestParam String commodity_id){
        clothingService.deleteClothById(commodity_id);
    }



    @RequestMapping("/selCloth")
    public List<CommodityClothing> selCloth(@RequestParam String keyword, @RequestParam String sort){
        System.out.println("电脑排序--关键字："+keyword+"；排序方式："+sort);

        if(keyword.equals("no key")){
            if(sort.equals("no")){
                return clothingService.selectAllClothing();
            }else{
                if(sort.equals("up")){
                    return  clothingService.selectClothOrderPriceUp();
                }else if(sort.equals("down")){
                    return clothingService.selectClothOrderPrice();
                }else if(sort.equals("nUp")){
                    return clothingService.selectByClothOrderBySaleNumUp();
                }else if(sort.equals("nDown")){
                    return clothingService.selectByClothOrderBySaleNumDown();
                }else if (sort.equals("sDown")){
                    return clothingService.selectByClothOrderByScoreDown();
                }else if(sort.equals("sUp")){
                    return clothingService.selectByClothOrderByScoreUp();
                }
            }
        }else{
            if(sort.equals("no")){
                return clothingService.selectClothByKeyword(keyword);
            }else{
                if(sort.equals("up")){
                    return  clothingService.selectByClothOrderByPriceUpByKeyword(keyword);
                }else if(sort.equals("down")){
                    return clothingService.selectByClothOrderByPriceDownByKeyword(keyword);
                }else if(sort.equals("nUp")){
                    return clothingService.selectClothOrderBySaleNumUpAndKeyword(keyword);
                }else if(sort.equals("nDown")){
                    return clothingService.selectClothOrderBySaleNumDownAndKeyword(keyword);
                }else if(sort.equals("sDown")){
                    return clothingService.selectByClothOrderByScoreDownByKeyword(keyword);
                }else if(sort.equals("sUp")){
                    return clothingService.selectByClothOrderByScoreUpByKeyword(keyword);
                }
            }
        }
        return null;
    }


    @RequestMapping("/selectClothBrand")
    public List<String> selectClothBrand(){
        return clothingService.selectClothBrand();
    }

    @RequestMapping("/selectClothSuitable")
    public List<String> selectClothSuitable(){
        return clothingService.selectClothSuitable();
    }

    @RequestMapping("/selectClothStyle")
    public List<String> selectClothStyle(){
        return clothingService.selectClothStyle();
    }

    @RequestMapping("/selectClothType")
    public List<String> selectClothType(){
        return clothingService.selectClothType();
    }


}
