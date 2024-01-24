package com.ka.store.pojo.type;

import org.springframework.stereotype.Component;

@Component
public class BookType {

    private int id;
    private String book_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }
}
