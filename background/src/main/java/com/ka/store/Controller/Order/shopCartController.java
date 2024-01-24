package com.ka.store.Controller.Order;

import com.ka.store.Service.Order.Shopping_cartService;
import com.ka.store.VO.shopVO.ShopCartVO;
import com.ka.store.pojo.order.Shopping_cart;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/shopCart")
public class shopCartController {

    @Resource
    Shopping_cartService shopping_cartService;

    @Resource
    Shopping_cart shopping_cart;


    @RequestMapping("/insertIntoShopCart")
    public void insertIntoShopCart(@RequestBody ShopCartVO shopCartVO,HttpSession session){
        System.out.println(shopCartVO);
        shopping_cart.setMerchant_id(shopCartVO.getCommodity().getMerchant_id());
        shopping_cart.setCommodity_id(shopCartVO.getCommodity().getCommodity_id());
        shopping_cart.setUser_id(session.getAttribute("user").toString());
        shopping_cart.setNum(shopCartVO.getNum());
        System.out.println(shopCartVO);
        if(shopping_cartService.selectCommodityByIdAndUserID(shopping_cart) == null ) {
            shopping_cartService.insertCommodityInShoppingCart(shopping_cart);
        }else{
            shopping_cart = shopping_cartService.selectShopByCommodityId(shopCartVO.getCommodity().getCommodity_id());
            shopping_cartService.increaseNum(shopping_cart);
        }
    }

}
