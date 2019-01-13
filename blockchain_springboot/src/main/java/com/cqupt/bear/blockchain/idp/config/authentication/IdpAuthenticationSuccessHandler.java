package com.cqupt.bear.blockchain.idp.config.authentication;

import com.cqupt.bear.blockchain.common.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Y.bear
 * @version 创建时间：2018年11月30日 下午4:33:42 类说明
 */
@Component
public class IdpAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String roles = JsonUtils.collectionToJson(authorities);
        String name = authentication.getName();
        logger.info("\"" + name + "\"登陆成功！" + roles);
        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/admin");
        } else if (roles.contains("ROLE_OFFICER")) {
            response.sendRedirect("/officer");
        } else {
            response.sendRedirect("/user");
        }
    }

}
