package com.ka.store.Service.Order;
import java.util.List;

import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.order.Shopping_cart;
import org.springframework.stereotype.Service;

@Service
public interface Shopping_cartService {

    public List<Shopping_cart> selectShoppingCartByUserId(String user_id);

    public Shopping_cart selectShopByCommodityId(String commodity_id);

    public void insertCommodityInShoppingCart(Shopping_cart shopping_cart);

    public void increaseNum(Shopping_cart shopping_cart);

    public void updateNum(Shopping_cart shopping_cart);

    public void deleteShop(String commodity_id);

    public Shopping_cart selectCommodityByIdAndUserID(Shopping_cart shopping_cart);

    public Shopping_cart JudgeShop(Shopping_cart shopping_cart);

    public List<Shopping_cart> selectShopMerchant(String user_id);

}
