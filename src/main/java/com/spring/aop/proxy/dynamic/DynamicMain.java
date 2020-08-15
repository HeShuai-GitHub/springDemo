package com.spring.aop.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @program: springDemo
 * @description: 动态代理 main方法
 * JDK动态代理，动过Proxy类来实现，利用反射机制在运行时创建代理类。
 * @author: hs
 * @create: 2020-08-14 19:56
 **/
public class DynamicMain {

    public static void main(String[] args) {
        HelloInterface hello=new HelloImpl();
        ProxyHandler handler=new ProxyHandler(hello);
//      通过Proxy类的静态方法newProxyInstance返回一个接口的代理实例
        HelloInterface helloInterface=(HelloInterface)Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),handler);
        helloInterface.sayHello();
        System.out.println("**********************");
        ByeInterface bye=new ByeImpl();
        //可使用同一个动态代理控制器来满足需要同样规则的委托类
        handler=new ProxyHandler(bye);
        ByeInterface byeInterface=(ByeInterface)Proxy.newProxyInstance(bye.getClass().getClassLoader(),bye.getClass().getInterfaces(),handler);
        byeInterface.sayBye();


    }

}
