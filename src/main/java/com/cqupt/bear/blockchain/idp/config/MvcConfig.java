package com.cqupt.bear.blockchain.idp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Y.bear
 * @version 创建时间：2018年11月27日 下午3:52:02 类说明
 *          addViewControllers可以方便的实现一个请求直接映射成视图，而无需书写controller
 *          registry.addViewController("请求路径").setViewName("请求页面文件路径")
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	//	registry.addViewController("/login").setViewName("index");
	}
}
