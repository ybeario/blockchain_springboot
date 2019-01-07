package com.cqupt.bear.blockchain.idp.config.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Y.bear
 * @version 创建时间：2018年11月28日 下午1:19:41 类说明
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String password = encoder.encode("123456");
        logger.info("password:" + password);
        Roles role = Roles.USER;
        switch (username) {
            case "admin":
                role = Roles.ADMIN;
                break;

            case "officer":
                role = Roles.OFFICER;
                break;

            case "user":
                role = Roles.USER;
                break;
        }
        UserDetails user = User.withUsername(username).password(password).roles(role.toString()).build();
        return user;
    }

}
