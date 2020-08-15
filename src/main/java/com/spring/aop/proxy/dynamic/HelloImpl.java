package com.spring.aop.proxy.dynamic;

/**
 * @program: springDemo
 * @description: 具体业务实现类，对HelloInterface的实现，在这里也叫委托类
 * @author: hs
 * @create: 2020-08-14 15:39
 **/
public class HelloImpl implements HelloInterface {

    public void sayHello() {
        System.out.println("HelloImpl：HELLO");
    }
}
