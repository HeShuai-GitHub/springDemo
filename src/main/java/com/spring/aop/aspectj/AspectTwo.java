package com.spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: springDemo
 * @description: 切面类，测试切面优先级及公共切入点表达式
 * @author: hs
 * @create: 2020-08-15 14:22
 **/
@Component
@Aspect
@Order(1) //@Order 设置切面类优先级，当有多个切面时，可以通过这个注解进行设置优先级，值越小，优先级越高。默认值为int的最大整数
public class AspectTwo {

    /**
     * @Pointcut 用来定义公共的切入点表达式，可以在使用切入点表达式时，直接使用该方法
     */
    @Pointcut("execution(* com.spring.aop.aspectj.*.*(..))")
    private void pointCut(){
    }

    /**
     * @Before 前置通知，value中直接放pointCut()表示切入点表达式
     */
    @Before("pointCut()")
    public void before(){
        System.out.println("前置二");
    }

}
