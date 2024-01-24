package com.ka.store.pojo.page;

import org.springframework.stereotype.Component;

@Component
public class Page_View {

    private int id;
    private int page_view;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage_view() {
        return page_view;
    }

    public void setPage_view(int page_view) {
        this.page_view = page_view;
    }
}
