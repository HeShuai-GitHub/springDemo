package com.spring.aop.proxy.static1;

import com.spring.aop.aspectj.HelloImpl;
import com.spring.aop.aspectj.HelloInterface;

/**
 * @program: springDemo
 * @description: 静态代理实现类，也就是代理类
 * @author: hs
 * @create: 2020-08-14 15:41
 **/
public class HelloProxy implements HelloInterface {

    private HelloInterface hello=new HelloImpl();

    public void sayHello() {
        System.out.println("Before");
        hello.sayHello();
        System.out.println("After");
    }
}
