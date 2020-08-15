package com.spring.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: aop aspectj 主main
 * spring aop的底层实现是使用了动态代理的设计模式，采用了JDK动态代理和cglib动态代理两种方式混合使用，当目标对象（委托类）
 * 有实现接口时，优先使用JDK动态代理，否则使用cglib动态代理
 * @author: hs
 * @create: 2020-08-15 09:29
 **/
public class AspectjMain {

    public static void main(String[] args) {
        //必须加载spring容器，才可以开启aspectj的功能
        ApplicationContext ap=new ClassPathXmlApplicationContext("aop/Aspectj-Context.xml");
        /**
         * 这里不可以获取HelloImpl这个类的bean，也不可以获取这个类型，因为在aop的运行中，已经将"helloImpl"重新包装
         * 成了一个代理类，而被spring ioc管理的也是这个代理类。当获得id为helloImpl的bean时获取到的是代理类，而不是HelloImpl
         * 这个类本身。
         * 因为这个代理类和HelloImpl类之间，在JDK动态代理中，是同时实现了同一个接口方法，所以不可以将代理类强转成HelloImpl类型，但是可以
         * 上转型成它们的接口HelloInterface
         */
        HelloInterface hello=ap.getBean("helloImpl",HelloInterface.class);
        hello.sayHello();
        /**
         * Bye未实现接口，默认使用cglib代理方式，以继承类的方式来实现动态打理
         */
        Bye bye=ap.getBean("bye",Bye.class);
        bye.sayBye();
    }

}
