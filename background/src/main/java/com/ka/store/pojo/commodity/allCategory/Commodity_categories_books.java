package com.ka.store.pojo.commodity.allCategory;

import com.ka.store.pojo.commodity.Commodity;
import com.ka.store.pojo.commodity.type.CommodityType.Commodity_type;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Component
public class Commodity_categories_books implements Serializable {

    private int id;
    private String commodityID;
    private String book_name;
    private String publishing;
    private String book_isbn;
    private String book_type;
    private String publishing_date;
    private String book_brand;
    private String number_of_pages;
    private String book_price;
    private String author;
    private List<Commodity_type> commodity_typeList;
    private Commodity commodity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(String commodityID) {
        this.commodityID = commodityID;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getPublishing_date() {
        return publishing_date;
    }

    public void setPublishing_date(String publishing_date) {
        this.publishing_date = publishing_date;
    }

    public String getBook_brand() {
        return book_brand;
    }

    public void setBook_brand(String book_brand) {
        this.book_brand = book_brand;
    }

    public String getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(String number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public List<Commodity_type> getCommodity_typeList() {
        return commodity_typeList;
    }

    public void setCommodity_typeList(List<Commodity_type> commodity_typeList) {
        this.commodity_typeList = commodity_typeList;
    }

    @Override
    public String toString() {
        return "Commodity_categories_books{" +
                "id=" + id +
                ", commodityID='" + commodityID + '\'' +
                ", book_name='" + book_name + '\'' +
                ", publishing='" + publishing + '\'' +
                ", book_isbn='" + book_isbn + '\'' +
                ", book_type='" + book_type + '\'' +
                ", publishing_date='" + publishing_date + '\'' +
                ", book_brand='" + book_brand + '\'' +
                ", number_of_pages='" + number_of_pages + '\'' +
                ", book_price='" + book_price + '\'' +
                ", author='" + author + '\'' +
                ", commodity=" + commodity +
                '}';
    }
}
