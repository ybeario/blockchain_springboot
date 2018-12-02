package com.cqupt.bear.blockchain.idp.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Y.bear
 * @version 创建时间：2018年11月30日 下午6:55:00 类说明
 */
@Component
public class UrlFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		logger.info("Url过滤器已启动");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String url = httpServletRequest.getRequestURL().toString();
		logger.info(url);
		if (url.endsWith(".html")) {
			url = url.substring(0, url.length() - 5);
			logger.info("成功处理请求中的.html->>" + url);
			httpServletResponse.sendRedirect(url);
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		logger.warn("Url过滤器已销毁");
	}

}
