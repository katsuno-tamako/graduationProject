package com.ka.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("配置文件已经生效");
        String path = "D:\\graduation project\\background\\src\\main\\resources\\static\\images\\";
        registry
                .addResourceHandler("/images/**")
                .addResourceLocations("file:"+path);
    }

}
