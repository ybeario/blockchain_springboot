package com.cqupt.bear.blockchain.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Y.bear
 * @version 创建时间：2018年11月27日 下午3:52:02 类说明
 * addViewControllers可以方便的实现一个请求直接映射成视图，而无需书写controller
 * registry.addViewController("请求路径").setViewName("请求页面文件路径")
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/success").setViewName("success");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/admin").setViewName("admin/adminIndex");
        registry.addViewController("/officer").setViewName("officer/officerIndex");
        registry.addViewController("/user").setViewName("user/userIndex");
        registry.addViewController("/user/upload").setViewName("user/upload");
        registry.addViewController("/user/queryPage").setViewName("user/query");
    }
}
