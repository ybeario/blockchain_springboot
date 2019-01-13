package com.cqupt.bear.blockchain.aspect.service;

import com.cqupt.bear.blockchain.aspect.entity.RequestLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Y.bear
 * @version 创建时间：2018年9月1日 下午2:07:56 类说明
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    // @Pointcut("execution(* com.cqupt.bear.blockchain.*.web.*.*(..))")
    // public void log() {
    //
    // }

    @Before("execution(* com.cqupt.bear.blockchain.*.web.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        String url = requestAttributes.getRequest().getRequestURL().toString();
        String ip = requestAttributes.getRequest().getRemoteAddr();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request: {} ", requestLog);
    }
}
