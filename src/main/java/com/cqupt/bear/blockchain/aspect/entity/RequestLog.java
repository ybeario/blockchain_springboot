package com.cqupt.bear.blockchain.aspect.entity;

import java.util.Arrays;

/**
 * @author Y.bear
 * @version 创建时间：2018年9月1日 下午2:16:54 类说明
 */
public class RequestLog {
    private String url;
    private String ip;
    private String classMethod;
    private Object[] args;

    public RequestLog(String url, String ip, String classMethod, Object[] args) {
        super();
        this.url = url;
        this.ip = ip;
        this.classMethod = classMethod;
        this.args = args;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "RequestLog [url=" + url + ", ip=" + ip + ", classMethod=" + classMethod + ", args="
                + Arrays.toString(args) + "]";
    }

}
