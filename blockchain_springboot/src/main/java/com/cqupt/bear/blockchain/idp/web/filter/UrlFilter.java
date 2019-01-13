package com.cqupt.bear.blockchain.idp.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        if (url.startsWith("https://127.0.0.1") || url.startsWith("https://ybear-web")
                || url.startsWith("https://www.ybear-web")) {
            logger.info(url);
            if (url.endsWith(".html")) {
                url = url.substring(0, url.length() - 5);
                logger.info("成功处理请求中的.html->>" + url);
                httpServletResponse.sendRedirect(url);
            } else {
                chain.doFilter(request, response);
            }
        } else {
            logger.info(url + "异常，被指向301");
            httpServletResponse.setStatus(HttpStatus.MOVED_PERMANENTLY.value());
        }
    }

    @Override
    public void destroy() {
        logger.warn("Url过滤器已销毁");
    }

}
