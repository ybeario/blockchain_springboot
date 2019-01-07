package com.cqupt.bear.blockchain.idp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Y.bear
 * @version 创建时间：2018年9月29日 下午3:30:54 类说明
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String getIndex() {
        return "login";
    }


}
