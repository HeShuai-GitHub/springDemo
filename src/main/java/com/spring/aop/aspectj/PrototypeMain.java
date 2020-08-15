package com.spring.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: 通过spring 原生aop的方法来创建切面
 * @author: hs
 * @create: 2020-08-15 14:53
 **/
public class PrototypeMain {

    public static void main(String[] args) {
        ApplicationContext ap=new ClassPathXmlApplicationContext("aop/Prototype-Context.xml");
        Bye bye=ap.getBean("bye",Bye.class);
        bye.sayBye();
    }

}
