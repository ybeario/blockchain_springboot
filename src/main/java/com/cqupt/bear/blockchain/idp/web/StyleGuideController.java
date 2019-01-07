package com.cqupt.bear.blockchain.idp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Y.bear
 * @version 创建时间：2018年11月29日 下午3:42:00 类说明
 */
@Controller
public class StyleGuideController {
    @GetMapping("/styleguide")
    public String getStyleguide() {
        return "styleguide";
    }
}
