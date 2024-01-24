package com.ka.store.dao;

import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.order.Order_info;
import com.ka.store.pojo.order.Shopping_cart;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface Shopping_cartDao {

    public List<Shopping_cart> selectShoppingCart(String user_id);

    public Shopping_cart selectShopByCommodityId(String commodity_id);

    public void insertInCart(Shopping_cart shopping_cart);

    public void increaseNum(Shopping_cart shopping_cart);

    public void updateNum(Shopping_cart shopping_cart);

    public void deleteShopCart(String commodity_id);

    public List<Order_info> selectOrderByMerchant(String merchant_id);

    public Shopping_cart selectCommodityByIdAndUserID(Shopping_cart shopping_cart);

//    public Shopping_cart JudgeShop(Shopping_cart shopping_cart);

    public List<Shopping_cart> selectShopMerchant(String user_id);


}
