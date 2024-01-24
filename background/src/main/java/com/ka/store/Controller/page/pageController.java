package com.ka.store.Controller.page;

import com.ka.store.Service.page.Page_viewService;
import com.ka.store.pojo.page.Page_View;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/page")
public class pageController {

    @Resource
    Page_viewService page_viewService;

    @RequestMapping("/getPageView")
    public int getPageView(){
        return page_viewService.getPageView();
    }

    @RequestMapping("/addPageView")
    public void addPageView(){
        page_viewService.addPageView();
    }

}
