package com.ka.store.Controller.Commodity;

import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Commodity.food.FoodService;
import com.ka.store.Service.sales.Sales_commodityService;
import com.ka.store.config.ImgCon;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.allCategory.Commodity_categories_computer;
import com.ka.store.pojo.commodity.food.Food;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/food")
public class foodController {

    @Resource
    CommodityService commodityService;

    @Resource
    Food food;

    @Resource
    FoodService foodService;

    @Resource
    Commodity commodity;

    @Resource
    usFunc func;

    @Resource
    ImgCon imgCon;

    @Resource
    Sales_commodity sales_commodity;
    @Resource
    Sales_commodityService sales_commodityService;

    @RequestMapping("/selectAllFoodInfo")
    public List<Food> selectAllFoodInfo(){
        return foodService.selectAllFood();
    }

    @RequestMapping("/selectFoodById")
    public Food selectFoodById(@RequestParam String commodity_id){
        return foodService.selectFoodById(commodity_id);
    }

    @RequestMapping("/insertFoodInfo")
    public String insertFoodInfo(@RequestBody Food f, HttpSession session){
        String commodity_id = func.getFN("food");
        f.setCommodity_id(commodity_id);
        f.getCommodity().setName(f.getName());
        f.getCommodity().setCategory("食品");
        f.getCommodity().setPrice(f.getPrice());
        f.getCommodity().setCommodity_id(f.getCommodity_id());
        f.getCommodity().setMerchant_id(session.getAttribute("merchantId").toString());
        foodService.insertFoodInfo(f);


        sales_commodity.setAve_grade("no");
        sales_commodity.setCommodity_id(f.getCommodity_id());
        sales_commodity.setSales_num(0);
        System.out.println(sales_commodity);
        sales_commodityService.insertCommoditySalesInfo(sales_commodity);

        return commodity_id;
    }

    @RequestMapping("/receiveFoodImg")
    @CrossOrigin
    public synchronized void receiveFoodImg(@RequestParam("file") MultipartFile file, @RequestParam(value="commodity_id") String commodity_id){
        imgCon.insertImg(file,commodity_id);
    }

    @RequestMapping("/updateFoodInfo")
    public void updateFoodInfo(@RequestBody Food f){
        f.getCommodity().setPrice(f.getPrice());
        f.getCommodity().setName(f.getName());
        f.getCommodity().setCommodity_id(f.getCommodity_id());
        System.out.println("update food info : "+f);
        foodService.updateFoodInfo(f);
    }

    @RequestMapping("/deleteFoodById")
    public void deleteFoodById(@RequestParam String commodity_id){
        System.out.println("delete food:"+commodity_id);
        commodityService.deleteCommodity(commodity_id);
        foodService.deleteFoodById(commodity_id);
    }

    @RequestMapping("/selFood")
    public List<Food> selFood(@RequestParam String keyword, @RequestParam String sort){
        System.out.println("电脑排序--关键字："+keyword+"；排序方式："+sort);
        if(keyword.equals("no key")){
            if (sort.equals("no")){
                return foodService.selectAllFood();
            }else{
                if(sort.equals("up")){
                    return  foodService.selectFoodOrderPriceUp();
                }else if(sort.equals("down")){
                    return foodService.selectFoodOrderPrice();
                }else if(sort.equals("nUp")){
                    return foodService.selectByFoodOrderBySaleNumUp();
                }else if(sort.equals("nDown")){
                    return foodService.selectByFoodOrderBySaleNumDown();
                }else if (sort.equals("sDown")){
                    return foodService.selectByFoodOrderByScoreDown();
                }else if(sort.equals("sUp")){
                    return foodService.selectByFoodOrderByScoreUp();
                }
            }
        }else{
            if(sort.equals("no")){
                return foodService.selectFoodByKeyword(keyword);
            }else{
                if(sort.equals("up")){
                    return  foodService.selectByFoodOrderByPriceUpByKeyword(keyword);
                }else if(sort.equals("down")){
                    return foodService.selectByFoodOrderByPriceDownByKeyword(keyword);
                }else if(sort.equals("nUp")){
                    return foodService.selectFoodOrderBySaleNumUpAndKeyword(keyword);
                }else if(sort.equals("nDown")){
                    return foodService.selectFoodOrderBySaleNumDownAndKeyword(keyword);
                }else if(sort.equals("sDown")){
                    return foodService.selectByFoodOrderByScoreDownByKeyword(keyword);
                }else if(sort.equals("sUp")) {
                    return  foodService.selectByFoodOrderByScoreUpByKeyword(keyword);
                }
            }
        }
        return null;
    }

    @RequestMapping("/selectFoodType")
    public List<String> selectFoodType(){
        return foodService.selectFoodType();
    }

}
