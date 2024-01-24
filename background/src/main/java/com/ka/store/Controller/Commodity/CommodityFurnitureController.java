package com.ka.store.Controller.Commodity;
import java.util.List;

import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Commodity.furniture.FurnitureService;
import com.ka.store.Service.sales.Sales_commodityService;
import com.ka.store.config.ImgCon;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.furniture.CommodityFurniture;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/furniture")
public class CommodityFurnitureController {

    @Resource
    usFunc func;

    @Resource
    Commodity commodity;

    @Resource
    FurnitureService furnitureService;

    @Resource
    CommodityService commodityService;

    @Resource
    Sales_commodity sales_commodity;

    @Resource
    Sales_commodityService sales_commodityService;

    @RequestMapping("/selectAllFurniture")
    public List<CommodityFurniture> selectAllFurniture(){
        return furnitureService.selectAllFurniture();
    }

    @RequestMapping("/insertFurniture")
    public String insertFurniture(@RequestBody CommodityFurniture commodityFurniture, HttpSession session){
        String commodity_id = func.getFN("fur");
        commodityFurniture.setCommodity_id(commodity_id);
        commodityFurniture.getCommodity().setName(commodityFurniture.getName());
        commodityFurniture.getCommodity().setCategory("家具");
        commodityFurniture.getCommodity().setPrice(commodityFurniture.getPrice());
        commodityFurniture.getCommodity().setCommodity_id(commodityFurniture.getCommodity_id());
        commodityFurniture.getCommodity().setMerchant_id(session.getAttribute("merchantId").toString());
        furnitureService.insertFurniture(commodityFurniture);
        sales_commodity.setAve_grade("no");
        sales_commodity.setCommodity_id(commodityFurniture.getCommodity_id());
        sales_commodity.setSales_num(0);
        sales_commodityService.insertCommoditySalesInfo(sales_commodity);
        return commodity_id;
    }


    @Resource
    ImgCon imgCon;

    @RequestMapping("/receiveFurnitureImg")
    @CrossOrigin
    public synchronized void receiveFurnitureImg(@RequestParam("file") MultipartFile file, @RequestParam(value="commodity_id") String commodity_id){
        imgCon.insertImg(file,commodity_id);
    }


        @RequestMapping("/updateFurniture")
    public void updateFurnitureById(@RequestBody CommodityFurniture commodityFurniture){
        System.out.println("update接受的数据："+commodityFurniture);
        commodityFurniture.getCommodity().setName(commodityFurniture.getName());
        commodityFurniture.getCommodity().setPrice(commodityFurniture.getPrice());
        commodityFurniture.getCommodity().setCommodity_id(commodityFurniture.getCommodity_id());
        furnitureService.updateFurnitureById(commodityFurniture);
    }

    @RequestMapping("/deleteFurnitureById")
    public void deleteFurnitureById(@RequestParam String commodity_id){
        furnitureService.deleteFurnitureById(commodity_id);
    }

    @RequestMapping("/selectFurnitureById")
    public CommodityFurniture selectFurnitureById(@RequestParam String commodity_id){
        System.out.println(commodity_id);
        System.out.println(furnitureService.selectFurnitureById(commodity_id));
        return furnitureService.selectFurnitureById(commodity_id);
    }



    @RequestMapping("/selFurniture")
    public List<CommodityFurniture> selFurniture(@RequestParam String keyword,@RequestParam String sort){
        System.out.println("电脑排序--关键字："+keyword+"；排序方式："+sort);

        if(keyword.equals("no key")){
            if(sort.equals("no")){
                return furnitureService.selectAllFurniture();
            }else{
                if(sort.equals("up")){
                    return  furnitureService.selectFurnitureOrderPriceUp();
                }else if(sort.equals("down")){
                    return furnitureService.selectFurnitureOrderPrice();
                }else if(sort.equals("nUp")){
                    return furnitureService.selectByFurnitureOrderBySaleNumUp();
                }else if(sort.equals("nDown")){
                    return furnitureService.selectByFurnitureOrderBySaleNumDown();
                }else if (sort.equals("sDown")){
                    return furnitureService.selectByFurnitureOrderByScoreDown();
                }else if(sort.equals("sUp")){
                    return furnitureService.selectByFurnitureOrderByScoreUp();
                }
            }
        }else{
            if(sort.equals("no")){
                return furnitureService.selectFurnitureByKeyword(keyword);
            }else{
                if(sort.equals("up")){
                    return  furnitureService.selectByFurnitureOrderByPriceUpByKeyword(keyword);
                }else if(sort.equals("down")){
                    return furnitureService.selectByFurnitureOrderByPriceDownByKeyword(keyword);
                }else if(sort.equals("nUp")){
                    return furnitureService.selectByFurnitureOrderByScoreDownByKeyword(keyword);
                }else if(sort.equals("nDown")){
                    return furnitureService.selectByFurnitureOrderByScoreUpByKeyword(keyword);
                }else if(sort.equals("sDown")){
                    return furnitureService.selectFurnitureOrderBySaleNumDownAndKeyword(keyword);
                }else if(sort.equals("sUp")){
                    return furnitureService.selectFurnitureOrderBySaleNumUpAndKeyword(keyword);
                }
            }
        }
        return null;
    }


    @RequestMapping("/selectFurnitureType")
    public List<String> selectFurnitureType(){
        return furnitureService.selectFurnitureType();
    }

    @RequestMapping("/selectFurnitureStyle")
    public List<String> selectFurnitureStyle(){
        return furnitureService.selectFurnitureStyle();
    }

    @RequestMapping("/selectFurnitureBrand")
    public List<String> selectFurnitureBrand(){
        return furnitureService.selectFurnitureBrand();
    }


}
