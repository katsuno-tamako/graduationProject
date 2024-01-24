package com.ka.store.VO.logisticVO;

import com.ka.store.pojo.logistics.Logistics;
import com.ka.store.pojo.order.Merchant_order;
import org.springframework.stereotype.Component;

@Component
public class LogisticsVO {

    private Logistics logistics;
    private Merchant_order merchant_order;

    public Logistics getLogistics() {
        return logistics;
    }

    public void setLogistics(Logistics logistics) {
        this.logistics = logistics;
    }

    public Merchant_order getMerchant_order() {
        return merchant_order;
    }

    public void setMerchant_order(Merchant_order merchant_order) {
        this.merchant_order = merchant_order;
    }

    @Override
    public String toString() {
        return "LogisticsVO{" +
                "logistics=" + logistics +
                ", merchant_order=" + merchant_order +
                '}';
    }
}
