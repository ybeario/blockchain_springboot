package com.cqupt.bear.blockchain.common.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author Y.bear
 * @version 创建时间：2018年10月20日 下午12:22:06 类说明
 */
public class JsoupUtils {
    /**
     * html->dom
     *
     * @param htmlString
     * @return
     */
    public static Document getDomFromString(String htmlString) {
        Document document = Jsoup.parse(htmlString);
        return document;
    }

    /**
     * 根据id获取value(input)
     *
     * @param document
     * @param id
     * @return
     */
    public static String getElementById(Document document, String id) {
        Element element = document.getElementById(id);
        return element.attr("value");
    }
}
