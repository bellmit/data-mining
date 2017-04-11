package com.jdrx.dm.rs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class SpringMVCConfig {

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        freeMarkerViewResolver.setPrefix("");
        freeMarkerViewResolver.setSuffix(".html");
        freeMarkerViewResolver.setCache(false);
        freeMarkerViewResolver.setOrder(1);
        freeMarkerViewResolver.setContentType("text/html;charset=UTF-8");
        freeMarkerViewResolver.setExposeSessionAttributes(true);
        freeMarkerViewResolver.setExposeRequestAttributes(true);
        freeMarkerViewResolver.setRequestContextAttribute("request");
        return freeMarkerViewResolver;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(InternalResourceView.class);
        internalResourceViewResolver.setPrefix("");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setCache(false);
        internalResourceViewResolver.setOrder(2);
        internalResourceViewResolver.setContentType("text/html;charset=UTF-8");
        internalResourceViewResolver.setRequestContextAttribute("request");
        return internalResourceViewResolver;
    }

}
