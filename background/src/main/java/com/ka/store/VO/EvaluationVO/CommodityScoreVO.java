package com.ka.store.VO.EvaluationVO;

import org.springframework.stereotype.Component;

@Component
public class CommodityScoreVO {

    private String commodity_id;
    private String order_id;
    private int score;

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
