package com.ka.store.pojo.logistics;

import com.ka.store.pojo.order.Order_main;
import com.ka.store.pojo.order.Order_table;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class Logistics {

    private int id;
    private String logistics_id;
    private String logistics_company;
    private String logistics_status;
    private String logistics_date;
    private String dispatch;
    private String receive;
    private String receive_people;
    private String dispatch_people;
    private List<Order_table> order_tables;
    private Order_main order_main;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogistics_id() {
        return logistics_id;
    }

    public void setLogistics_id(String logistics_id) {
        this.logistics_id = logistics_id;
    }

    public String getLogistics_company() {
        return logistics_company;
    }

    public void setLogistics_company(String logistics_company) {
        this.logistics_company = logistics_company;
    }

    public String getLogistics_status() {
        return logistics_status;
    }

    public void setLogistics_status(String logistics_status) {
        this.logistics_status = logistics_status;
    }

    public String getLogistics_date() {
        return logistics_date;
    }

    public void setLogistics_date(String logistics_date) {
        this.logistics_date = logistics_date;
    }

    public String getDispatch() {
        return dispatch;
    }

    public void setDispatch(String dispatch) {
        this.dispatch = dispatch;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getReceive_people() {
        return receive_people;
    }

    public void setReceive_people(String receive_people) {
        this.receive_people = receive_people;
    }

    public String getDispatch_people() {
        return dispatch_people;
    }

    public void setDispatch_people(String dispatch_people) {
        this.dispatch_people = dispatch_people;
    }

    public List<Order_table> getOrder_tables() {
        return order_tables;
    }

    public void setOrder_tables(List<Order_table> order_tables) {
        this.order_tables = order_tables;
    }

    public Order_main getOrder_main() {
        return order_main;
    }

    public void setOrder_main(Order_main order_main) {
        this.order_main = order_main;
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "id=" + id +
                ", logistics_id='" + logistics_id + '\'' +
                ", logistics_company='" + logistics_company + '\'' +
                ", logistics_status='" + logistics_status + '\'' +
                ", logistics_date='" + logistics_date + '\'' +
                ", dispatch='" + dispatch + '\'' +
                ", receive='" + receive + '\'' +
                ", receive_people='" + receive_people + '\'' +
                ", dispatch_people='" + dispatch_people + '\'' +
                ", order_tables=" + order_tables +
                ", order_main=" + order_main +
                '}';
    }
}
