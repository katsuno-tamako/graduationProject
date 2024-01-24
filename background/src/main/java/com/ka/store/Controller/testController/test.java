package com.ka.store.Controller.testController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.dao.CommodityDao;
import com.ka.store.pojo.commodity.Commodity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class test {

    @Resource
    CommodityDao commodityDao;

    @Resource
    CommodityService commodityService;


    @RequestMapping("/test")
    public void test(){
        System.out.println(commodityService.selectCommodityByMerchant("ka123"));
    }



    @RequestMapping("/testD")
    public void testD(){
        System.out.println("successful");
    }


    @RequestMapping("/testMd")
    public void testMd(@RequestBody JSONPObject value){
        System.out.println(value);
    }



}
