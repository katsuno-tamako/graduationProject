package com.ka.store.Controller.payment;

import com.ka.store.Service.Order.Merchant_orderService;
import com.ka.store.Service.Order.OrderTableService;
import com.ka.store.Service.Order.Shopping_cartService;
import com.ka.store.Service.sales.Sales_commodityService;
import com.ka.store.VO.payVO.PayVO;
import com.ka.store.config.usFunc;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.merchant.Merchant_Info;
import com.ka.store.pojo.order.Merchant_order;
import com.ka.store.pojo.order.Order_product;
import com.ka.store.pojo.order.Order_table;
import com.ka.store.pojo.order.Shopping_cart;
import com.ka.store.pojo.sale.Sales_commodity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/pay")
public class payController {

    @Resource
    usFunc func;

    @Resource
    Merchant_order merchant_order;

    @Resource
    Merchant_Info merchant_info;

    @Resource
    Order_product order_product;

    @Resource
    Order_table order_table;

    @Resource
    Merchant_orderService merchant_orderService;

    @Resource
    OrderTableService orderTableService;

    @Resource
    Shopping_cartService shopping_cartService;

    @Resource
    Sales_commodity sales_commodity;

    @Resource
    Sales_commodityService sales_commodityService;


    //支付，提交订单， paymentPage页面：→
    @RequestMapping("/payment")
    public void receiveInfo(@RequestBody PayVO pay_info, HttpSession session){
        for(String mer : pay_info.getMerchant_id()){
            merchant_order.setMerchant_id(mer);
            merchant_order.setOrder_id(func.getFN("order"));
            merchant_order.setOrder_status("待处理");
            merchant_order.setOrder_date(func.getDate());
            System.out.println("当前商家："+merchant_order.getMerchant_id());
            merchant_order.setUser_address_id(pay_info.getUser_address());
            merchant_orderService.insertOrder_MerchantTable(merchant_order);
            for(Shopping_cart shop : pay_info.getShopping_carts()){
                if(shop.getMerchant_id().equals(merchant_order.getMerchant_id())){
                    System.out.println("带准备插入的商品："+shop.getCommodity().getName());
                    order_table.setUser_id(session.getAttribute("user").toString());
                    order_table.setCommodity_id(shop.getCommodity_id());
                    order_table.setOrder_id(merchant_order.getOrder_id());
                    order_table.setUser_address_id(pay_info.getUser_address());
                    order_table.setStatus("0");
                    order_table.setNum(shop.getNum());
                    System.out.println("insert into order table value is : "+order_table);
                    System.out.println("-----");
                    orderTableService.insertOrderTable(order_table);
                    shopping_cartService.deleteShop(order_table.getCommodity_id());

                    sales_commodity.setCommodity_id(order_table.getCommodity_id());
                    sales_commodity.setSales_num(order_table.getNum());
                    sales_commodityService.increaseSalesNum(sales_commodity);
                }
            }
            System.out.println("--------------------");
        }

    }

}
