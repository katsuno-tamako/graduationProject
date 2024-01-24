package com.ka.store.pojo.order;

import com.ka.store.pojo.comment.User_commodity_evaluate;
import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.logistics.Logistics;
import com.ka.store.pojo.user.User_address;
import com.ka.store.pojo.user.User_info;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Component
public class Order_table {

    private int id;
    private String order_id;
    private String user_id;
    private String commodity_id;
    private String logistics_id;
    private String user_address_id;
    private int num;
    private String status;
    private Logistics logistics;
    private Commodity commodity;
    private User_info user;
    private User_address user_address;
    private List<User_commodity_evaluate> user_commodity_evaluates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getLogistics_id() {
        return logistics_id;
    }

    public void setLogistics_id(String logistics_id) {
        this.logistics_id = logistics_id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public User_info getUser() {
        return user;
    }

    public void setUser(User_info user) {
        this.user = user;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Logistics getLogistics() {
        return logistics;
    }

    public void setLogistics(Logistics logistics) {
        this.logistics = logistics;
    }

    public String getUser_address_id() {
        return user_address_id;
    }

    public void setUser_address_id(String user_address_id) {
        this.user_address_id = user_address_id;
    }

    public User_address getUser_address() {
        return user_address;
    }

    public void setUser_address(User_address user_address) {
        this.user_address = user_address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User_commodity_evaluate> getUser_commodity_evaluates() {
        return user_commodity_evaluates;
    }

    public void setUser_commodity_evaluates(List<User_commodity_evaluate> user_commodity_evaluates) {
        this.user_commodity_evaluates = user_commodity_evaluates;
    }

    @Override
    public String toString() {
        return "Order_table{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", commodity_id='" + commodity_id + '\'' +
                ", logistics_id='" + logistics_id + '\'' +
                ", user_address_id='" + user_address_id + '\'' +
                ", num=" + num +
                ", status='" + status + '\'' +
                ", logistics=" + logistics +
                ", commodity=" + commodity +
                ", user=" + user +
                ", user_address=" + user_address +
                '}';
    }
}
