package com.spring.aop.aspectj;

import com.spring.aop.proxy.dynamic.ByeInterface;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @program: springDemo
 * @description: 测试切入点表达式及cglib代理方式
 * @author: hs
 * @create: 2020-08-14 15:39
 **/
@Component
public class Bye {
    public void sayBye() {
        System.out.println("ByeImpl：Bye");
    }
}
