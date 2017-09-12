package com.example.aspect;

import com.example.util.MyLogger;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by GuYang on 2017/9/12.
 */
@Aspect
@Component
public class HttAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttAspect.class);
    @Pointcut("execution(public * com.example.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void log1(JoinPoint joinPoint) {
        //url
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());
        //ip
         logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_name={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //请求参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void log2() {
        MyLogger.getLogger(HttAspect.class).info("3333333333");
    }

    @AfterReturning(returning = "o", pointcut ="log()")
    public void doafter(Object o){
        logger.info("reponse={}",o.toString());
    }
}
