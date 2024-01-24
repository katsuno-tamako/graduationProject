package com.ka.store.Controller.Order;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import com.ka.store.Service.Commodity.CommodityService;
import com.ka.store.Service.Order.*;
import com.ka.store.Service.sales.Sales_commodityService;
import com.ka.store.VO.EvaluationVO.CommodityScoreVO;
import com.ka.store.config.usFunc;
import com.ka.store.dao.Order_infoDao;
import com.ka.store.pojo.comment.User_commodity_evaluate;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.order.*;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

@RestController
@RequestMapping("/order")
public class orderController {

    @Resource
    Shopping_cartService shopping_cartService;

    @Resource
    Shopping_cart shopping_cart;

    @Resource
    Order_info order_info;

    @Resource
    Order_infoDao order_infoDao;

    @Resource
    usFunc func;


    @RequestMapping("/selectShoppingCartByUserId")
    public List<Shopping_cart> selectShoppingCartByUserId(@RequestParam String commodity_id){
        System.out.println(commodity_id);
        return shopping_cartService.selectShoppingCartByUserId(commodity_id);
    }

    @RequestMapping("/getShoppingCount")
    public int getShoppingCount(@RequestParam String commodity_id){
        return shopping_cartService.selectShoppingCartByUserId(commodity_id).size();

    }

    @RequestMapping("/insertCommodityInShoppingCart")
    public void insertCommodityInShoppingCart(@RequestParam String commodity_id,@RequestParam String user_id,@RequestParam int num,@RequestParam String merchant_id){
        shopping_cart.setCommodity_id(commodity_id);
        shopping_cart.setUser_id(user_id);
        shopping_cart.setMerchant_id(merchant_id);
//        shopping_cart.setNum(num);
        if(shopping_cartService.selectCommodityByIdAndUserID(shopping_cart) == null ){
            shopping_cart.setCommodity_id(commodity_id);
            shopping_cart.setUser_id(user_id);
            shopping_cart.setNum(num);
            shopping_cartService.insertCommodityInShoppingCart(shopping_cart);
        }else{
            shopping_cart = shopping_cartService.selectShopByCommodityId(commodity_id);
            shopping_cartService.increaseNum(shopping_cart);
        }
    }

    @RequestMapping("/selectShopMerchant")
    public List<Shopping_cart> selectShopMerchant(HttpSession session){
        return shopping_cartService.selectShopMerchant(session.getAttribute("user").toString());
    }


    @RequestMapping("/updateNum")
    public void updateNum(@RequestParam String commodity_id,@RequestParam int num){
        shopping_cart.setNum(num);
        shopping_cart.setCommodity_id(commodity_id);
        shopping_cartService.updateNum(shopping_cart);
    }



    @RequestMapping("/getChoice")
    public void getChoice(@RequestParam String choice){
        System.out.println(choice);
    }

    @RequestMapping("/payOrder")
    public synchronized void payOrder(@RequestBody Shopping_cart[] shopping_carts,@RequestParam String address_id)  {

        for(int i=0; i<shopping_carts.length;i++){
            order_info.setOrder_date(func.getDate());
            String sub = shopping_carts[i].getCommodity_id().substring(6);
            order_info.setOrder_id(func.getFN("o")+sub);
            order_info.setNum(shopping_carts[i].getNum());
            order_info.setMerchant_id(shopping_carts[i].getCommodity().getMerchant_id());
            order_info.setCommodity_id(shopping_carts[i].getCommodity_id());
            order_info.setUser_id(shopping_carts[i].getUser_id());
            order_info.setUser_address_id(address_id);
            order_info.setOrder_wait_receive("未接收");
            order_info.setOrder_delivered("未送达");
            System.out.println(order_info);
            shopping_cartService.deleteShop(shopping_carts[i].getCommodity_id());
            order_infoDao.insertOrderInfo(order_info);
        }

    }

    @RequestMapping("/deleteShoppingByCommodityId")
    public void deleteShoppingByCommodityId(@RequestParam String commodity_id){
        shopping_cartService.deleteShop(commodity_id);
    }


    @Resource
    Order_infoService order_infoService;

    @RequestMapping("/selectOrderByMerchant")
    public List<Order_info> selectOrderByMerchant(@RequestParam String merchant_id){
        return order_infoService.selectOrderByMerchant(merchant_id);
    }

    @RequestMapping("/selectAllOrderInfo")
    public List<Order_info> selectAllOrderInfo(){
        return order_infoService.selectAll();
    }


    @RequestMapping("/JudgeShop")
    public String JudgeShop(@RequestParam String commodity_id,@RequestParam String user_id){
        shopping_cart.setUser_id(user_id);
        shopping_cart.setCommodity_id(commodity_id);
        System.out.println(shopping_cart);
        if(shopping_cartService.selectCommodityByIdAndUserID(shopping_cart)  == null){
            return "no";
        }else{
            return "have";
        }
    }

    @RequestMapping("/selectOrderByUser")
    public List<Order_info> selectOrderByUser(@RequestParam String user_id){
        System.out.println("按照用户id查找用户订单");
        return order_infoService.selectOrderByUser(user_id);
    }


    @RequestMapping("/test")
    public void testO(@RequestBody Shopping_cart[] shopping_carts,@RequestParam String address_id){

    }


    @RequestMapping("/selectOrderByDelivered")
    public synchronized List<Order_info> selectOrderByDelivered(@RequestParam String delivered,HttpSession session){
        order_info.setOrder_delivered(delivered);
        order_info.setUser_id(session.getAttribute("user").toString());
        System.out.println("selectOrderByDelivered"+order_info);
        return order_infoService.selectOrderByDelivered(order_info);
    }


    @RequestMapping("/selectOrderByReceive")
        public synchronized List<Order_info> selectOrderByReceive(@RequestParam(name="receive") String receive, HttpSession session){
        order_info.setOrder_wait_receive(receive);
        order_info.setUser_id(session.getAttribute("user").toString());
        System.out.println("---");
        System.out.println("selectOrderByReceive"+order_info);
        return order_infoService.selectOrderByReceive(order_info);
    }

    @RequestMapping("/updateOrderStatusDe")
    public void updateOrderStatusDe(@RequestBody Order_info order_info){
        System.out.println(order_info);
        order_infoService.updateOrderStatusDe(order_info);
    }


    @RequestMapping("/updateOrderStatusRs")
    public void updateOrderStatusRs(@RequestBody Order_info info){
        order_infoService.updateOrderStatusRs(info);
    }

    @RequestMapping("/selectOrderByDeliveredByMerchantId")
    public List<Order_info> selectOrderByDeliveredByMerchantId(HttpSession session){
        order_info.setOrder_delivered("未送达");
        order_info.setMerchant_id(session.getAttribute("merchantId").toString());
        return order_infoService.selectOrderByDeliveredByMerchantId(order_info);
    }

    @RequestMapping("/selectOrderByReceiveByMerchantId")
    public List<Order_info> selectOrderByReceiveByMerchantId(HttpSession session){
        order_info.setOrder_delivered("已送达");
        order_info.setOrder_wait_receive("未接收");
        order_info.setMerchant_id(session.getAttribute("merchantId").toString());
        return order_infoService.selectOrderByReceiveByMerchantId(order_info);
    }

    @Resource
    Order_table order_table;

    @Resource
    OrderTableService orderTableService;

    @Resource
    Merchant_order merchant_order;

    @Resource
    Merchant_orderService merchant_orderService;

    @RequestMapping("/selectAllOrderTable")
    public List<Order_table> selectAllOrderTable(){
        return orderTableService.selectOrderTable();
    }

    @Resource
    CommodityService commodityService;

    @RequestMapping("/insertOrderTable")
    public void insertOrderTable(@RequestBody Map<String,Object> data,HttpSession session){


        int i=0;
        Map<String,Object> dataMap = (Map<String, Object>) data.get("data");
        Map<String,Object> orMap = (Map<String, Object>) dataMap.get("order_table");
        order_table.setOrder_id(func.getFN("or"));
        ArrayList<Object>  ordOb = (ArrayList<Object>) dataMap.get("shopping_cart");
        Map<String,Object> aryM;
        System.out.println("orMap map values is :" + orMap);
        order_main.setOrder_id(order_table.getOrder_id());
        order_main.setOrder_date(func.getDate());
        order_main.setUser_address_id((String) orMap.get("user_address"));
        System.out.println("insert into order_main : "+order_main);
        System.out.println("ordOb info : "+ordOb);
        List<Object> objects;
        for(Object o:ordOb){

        }

//        for(Object o:ordOb){
//            aryM = (Map<String, Object>) o;
//            order_table.setUser_id((String) aryM.get("user_id"));
//            order_table.setCommodity_id((String) aryM.get("commodity_id"));
//            order_table.setNum((Integer) aryM.get("num"));
//            order_table.setUser_address_id((String) orMap.get("user_address"));
//
//            order_table.setStatus("未处理");
//            System.out.println("插入的第"+i+"个数值为:"+order_table);
//
//            merchant_order.setMerchant_id(commodityService.selectMerchantByCommodityId(order_table.getCommodity_id()));
//            merchant_order.setOrder_id(order_table.getOrder_id());
//            System.out.println("merchant_order 中的 第"+i+"个数值为:"+merchant_order);
//
//            orderTableService.insertOrderTable(order_table);
//            shopping_cartService.deleteShop(order_table.getCommodity_id());
//            merchant_orderService.insertOrder_MerchantTable(merchant_order);
//            i++;
//        }
    }


    @Resource
    Order_main order_main;

    @Resource
    OrderMainService orderMainService;

    @RequestMapping("/selectAllOrderMain")
    public List<Order_main> selectAllOrderMain(){
        return  orderMainService.selectAllOrderMain();
    }

    @RequestMapping("/selectOrderMainByMerchant")
    public List<Order_main> selectOrderMainByMerchant(HttpSession session){
        return orderMainService.selectOrderMainByMerchant(session.getAttribute("merchantId").toString());
    }


    @RequestMapping("/selectOrderMerchantTableByMerchantId")
    public List<Merchant_order> selectOrderMerchantTableByMerchantId(HttpSession session){
        System.out.println(session.getAttribute("merchantId").toString());
        return merchant_orderService.selectOrderMerchantTableByMerchantId(session.getAttribute("merchantId").toString());
    }

    @RequestMapping("/selectAllMerchantOrderByUserId")
    public List<Merchant_order> selectAllMerchantOrderByUserId(HttpSession session){
        return merchant_orderService.selectOrderByUser(session.getAttribute("user").toString());
    }

    @RequestMapping("/selectOrderById")
    public Merchant_order selectOrderById(String order_id,HttpSession session){
        merchant_order.setMerchant_id(session.getAttribute("merchantId").toString());
        merchant_order.setOrder_id(order_id);
        return merchant_orderService.selectOrderById(merchant_order);
    }

    @Resource
    Sales_commodity sales_commodity;

    @Resource
    Sales_commodityService sales_commodityService;

    @RequestMapping("/scoreCommodity")
    public void scoreCommodity(HttpSession session,@RequestBody CommodityScoreVO commodityScoreVO){
        order_table.setOrder_id(commodityScoreVO.getOrder_id());
        order_table.setStatus(String.valueOf(commodityScoreVO.getScore()));
        order_table.setCommodity_id(commodityScoreVO.getCommodity_id());
        orderTableService.updateScoreStatus(order_table);
        sales_commodity.setCommodity_id(order_table.getCommodity_id());
        sales_commodity.setAve_grade(String.valueOf(commodityScoreVO.getScore()));
        System.out.println(sales_commodity);
        System.out.println("--"+sales_commodityService.selectAveByCommodityId(sales_commodity));
        if(sales_commodityService.selectAveByCommodityId(sales_commodity).equals("no")){
            System.out.println("--");
            sales_commodityService.insertAveScore(sales_commodity);
        }else {
            sales_commodityService.updateAveScore(sales_commodity);
        }
    }

    @RequestMapping("/getOrderNumber")
    public int getOrderNumber(){
        return merchant_orderService.getOrderNumber();
    }


}
