package com.ka.store.Controller.Logistics;
import java.util.List;

import com.ka.store.Service.Logistics.LogisticsService;
import com.ka.store.Service.Order.Merchant_orderService;
import com.ka.store.Service.Order.OrderMainService;
import com.ka.store.VO.logisticVO.LogisticsVO;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.logistics.Logistics;
import com.ka.store.pojo.order.Merchant_order;
import com.ka.store.pojo.order.Order_main;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

    @Resource
    Logistics logistics;

    @Resource
    LogisticsService logisticsService;

    @Resource
    usFunc func;

    @Resource
    OrderMainService orderMainService;

    @Resource
    Order_main order_main;

    @Resource
    Merchant_order merchant_order;

    @Resource
    Merchant_orderService merchant_orderService;

    @RequestMapping("/selectAllLogistics")
    public List<Logistics> selectAllLogistics(){
        return logisticsService.selectAllLogistics();
    }

    @RequestMapping("/insertLogistics")
    public void insertLogistics(@RequestBody  Logistics logistics){
        logistics.setLogistics_id(func.getFN("log"));
        logistics.setLogistics_date(func.getDate());
        logistics.setLogistics_status("待处理");
        order_main.setLogistics_id(logistics.getLogistics_id());
        order_main.setOrder_id(logistics.getOrder_main().getOrder_id());
        System.out.println(logistics);
        System.out.println(order_main);
        orderMainService.updateOrderLogistic(order_main);
        logisticsService.insertLogistics(logistics);
    }

    @RequestMapping("/insertLogisticsInfo")
    public void insertLogisticsInfo(@RequestBody LogisticsVO logisticsVO){
        logistics.setLogistics_status("发货中");
        logistics.setLogistics_date(func.getDate());
        logistics.setLogistics_id(func.getFN("log"));
        logistics.setDispatch(logisticsVO.getLogistics().getDispatch());
        logistics.setDispatch_people(logisticsVO.getLogistics().getDispatch_people());
        logistics.setLogistics_company(logisticsVO.getLogistics().getLogistics_company());
        logistics.setReceive(logisticsVO.getLogistics().getReceive());
        logistics.setReceive_people(logisticsVO.getLogistics().getReceive_people());
        merchant_order.setMerchant_id(logisticsVO.getMerchant_order().getMerchant_id());
        merchant_order.setOrder_status("运送中");
        merchant_order.setOrder_id(logisticsVO.getMerchant_order().getOrder_id());
        merchant_order.setLogistics_id(logistics.getLogistics_id());
        logisticsService.insertLogistics(logistics);
        merchant_orderService.updateMerchantTableStatus(merchant_order);
    }

    @RequestMapping("/editLogisticsStatus")
    public void editLogisticsStatus(@RequestParam String logistics_id){
        logistics.setLogistics_id(logistics_id);
        logistics.setLogistics_status("已送达");
        merchant_order.setLogistics_id(logistics.getLogistics_id());
        merchant_order.setOrder_status("已送达");
        System.out.println(merchant_order);
        logisticsService.updateLogisticsStatus(logistics);
        merchant_orderService.updateLogisticsStatus(merchant_order);

    }


}
