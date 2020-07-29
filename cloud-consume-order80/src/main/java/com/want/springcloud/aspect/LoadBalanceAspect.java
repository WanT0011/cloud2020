package com.want.springcloud.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * 客户端负载均衡的切面类
 *
 * @author want
 * @createTime 2020.07.29.22:08
 */
@Aspect
@Order(0)
public class LoadBalanceAspect {

//    @Pointcut("execution(public * com.want.springcloud.api.ConsumerApi.*(..))")
//    public void pointcut(){}
//
//    @Around("pointcut()"){
//
//    }
}
