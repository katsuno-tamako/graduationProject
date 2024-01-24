package com.ka.store.Controller.Commodity;
import java.util.List;
import com.ka.store.Service.Commodity.other.OtherService;
import com.ka.store.Service.sales.Sales_commodityService;
import com.ka.store.config.ImgCon;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.other.Other;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/other")
public class otherController {

    @Resource
    OtherService otherService;

    @Resource
    usFunc func;

    @Resource
    Commodity commodity;

    @Resource
    ImgCon imgCon;

    @Resource
    Sales_commodity sales_commodity;
    @Resource
    Sales_commodityService sales_commodityService;

    @RequestMapping("/selectAllOtherCommodity")
    public List<Other> selectAllOtherCommodity(){
        return otherService.selectAllOtherCommodity();
    }

    @RequestMapping("/selectOtherCommodityById")
    public Other selectOtherCommodityById(@RequestParam String commodity_id){
        return otherService.selectOtherCommodityById(commodity_id);
    }

    @RequestMapping("/insertOtherCommodity")
    public String insertOtherCommodity(@RequestBody Other other, HttpSession session){
        String commodity_id = func.getFN("other");
        other.setCommodity_id(commodity_id);
        other.getCommodity().setMerchant_id(session.getAttribute("merchantId").toString());
        other.getCommodity().setCommodity_id(other.getCommodity_id());
        other.getCommodity().setPrice(other.getPrice());
        other.getCommodity().setCategory("其他");
        other.getCommodity().setName(other.getCommodity_name());
        System.out.println(other);
        otherService.insertOtherCommodity(other);
        sales_commodity.setAve_grade("no");
        sales_commodity.setCommodity_id(other.getCommodity_id());
        sales_commodity.setSales_num(0);
        System.out.println(sales_commodity);
        sales_commodityService.insertCommoditySalesInfo(sales_commodity);
        return commodity_id;
    }



    @RequestMapping("/receiveOtherImg")
    @CrossOrigin
    public synchronized void receiveOtherImg(@RequestParam("file") MultipartFile file, @RequestParam(value="commodity_id") String commodity_id){
        imgCon.insertImg(file,commodity_id);
    }

    @RequestMapping("/updateOtherCommodity")
    public void updateOtherCommodity(@RequestBody Other other){
        other.getCommodity().setCommodity_id(other.getCommodity_id());
        other.getCommodity().setPrice(other.getPrice());
        other.getCommodity().setName(other.getCommodity_name());
        otherService.updateOtherCommodity(other);
    }

    @RequestMapping("/deleteOtherCommodityById")
    public void deleteOtherCommodityById(@RequestParam String commodity_id){
        otherService.deleteOtherCommodityById(commodity_id);
    }

}
