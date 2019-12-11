package com.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        //registry.addViewController("/login").setViewName("login");
    }

    //注册拦截器
/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有的请求
        //addPathPattern后跟拦截地址，excludePathPatterns后跟排除拦截地址
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/**","/doctor/**","/admin/**","/aper/**").excludePathPatterns("/static/**");
    }*/

    @Configuration
    public class WebMvcConfig extends WebMvcConfigurerAdapter{
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //将所有/static/** 访问都映射到classpath:/static/ 目录下
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
    }

}
