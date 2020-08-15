package com.spring.aop.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: springDemo
 * @description: 动态代理控制器,在委托类调用方法前后 输出一条语句
 * @author: hs
 * @create: 2020-08-14 19:46
 **/
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "+method.getName());
        Object object=method.invoke(this.object,args);
        System.out.println("After invoke "+method.getName());
        return object;
    }
}
