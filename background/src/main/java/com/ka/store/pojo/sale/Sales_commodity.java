package com.ka.store.pojo.sale;

import org.springframework.stereotype.Component;

@Component
public class Sales_commodity {

    private int id;
    private String commodity_id;
    private int sales_num;
    private String ave_grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public int getSales_num() {
        return sales_num;
    }

    public void setSales_num(int sales_num) {
        this.sales_num = sales_num;
    }

    public String getAve_grade() {
        return ave_grade;
    }

    public void setAve_grade(String ave_grade) {
        this.ave_grade = ave_grade;
    }

    @Override
    public String toString() {
        return "Sales_commodity{" +
                "id=" + id +
                ", commodity_id='" + commodity_id + '\'' +
                ", sales_num='" + sales_num + '\'' +
                ", ave_grade='" + ave_grade + '\'' +
                '}';
    }
}
