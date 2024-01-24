package com.ka.store.Service.Order.impl;

import com.ka.store.Service.Order.Shopping_cartService;
import com.ka.store.dao.Shopping_cartDao;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.order.Shopping_cart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Shopping_cartImpl implements Shopping_cartService {

    @Resource
    Shopping_cartDao shopping_cartDao;

    @Override
    public List<Shopping_cart> selectShoppingCartByUserId(String user_id) {
        return shopping_cartDao.selectShoppingCart(user_id);
    }

    @Override
    public Shopping_cart selectShopByCommodityId(String commodity_id) {
        return shopping_cartDao.selectShopByCommodityId(commodity_id);
    }

    @Override
    public void insertCommodityInShoppingCart(Shopping_cart shopping_cart) {
        shopping_cartDao.insertInCart(shopping_cart);
    }

    @Override
    public void increaseNum(Shopping_cart shopping_cart) {
        shopping_cartDao.increaseNum(shopping_cart);
    }

    @Override
    public void updateNum(Shopping_cart shopping_cart) {
        shopping_cartDao.updateNum(shopping_cart);
    }

    @Override
    public void deleteShop(String commodity_id) {
        shopping_cartDao.deleteShopCart(commodity_id);
    }

    @Override
    public Shopping_cart selectCommodityByIdAndUserID(Shopping_cart shopping_cart) {
        return shopping_cartDao.selectCommodityByIdAndUserID(shopping_cart);
    }

    @Override
    public Shopping_cart JudgeShop(Shopping_cart shopping_cart) {
        return shopping_cartDao.selectCommodityByIdAndUserID(shopping_cart);
    }

    @Override
    public List<Shopping_cart> selectShopMerchant(String user_id) {
        return shopping_cartDao.selectShopMerchant(user_id);
    }
}
