package com.ka.store.pojo.commodity.computer;

import org.springframework.stereotype.Component;

@Component
public class Computer_category {

    private int id;
    private String first_type;
    private String second_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_type() {
        return first_type;
    }

    public void setFirst_type(String first_type) {
        this.first_type = first_type;
    }

    public String getSecond_type() {
        return second_type;
    }

    public void setSecond_type(String second_type) {
        this.second_type = second_type;
    }

    @Override
    public String toString() {
        return "computer_category{" +
                "id=" + id +
                ", first_type='" + first_type + '\'' +
                ", second_type='" + second_type + '\'' +
                '}';
    }
}
