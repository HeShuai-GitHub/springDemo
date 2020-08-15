package com.spring.aop.aspectj;

import org.springframework.stereotype.Component;

/**
 * @program: springDemo
 * @description: 具体业务实现类，对HelloInterface的实现
 * @author: hs
 * @create: 2020-08-14 15:39
 **/
@Component
public class HelloImpl implements HelloInterface{

    public void sayHello() {
        /**
         * System.out.println("Before method")
         * 在Aspect中的前置通知中所执行的这个语句，本来应该是在现在这个位置执行的，在这里它称之为横向关注点
         */
        System.out.println("HelloImpl：HELLO");
    }
}
