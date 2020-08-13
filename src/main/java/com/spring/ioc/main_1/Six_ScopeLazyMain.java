package com.spring.ioc.main_1;

import com.spring.ioc.modal.ScopeLazy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: spring单例多里模式及是否延迟加载功能测试
 * @author: hs
 * @create: 2020-08-12 12:13
 **/
public class Six_ScopeLazyMain {


    public static void main(String[] args) {
        ApplicationContext ap=new ClassPathXmlApplicationContext("ScopeLazy-Context.xml");
        //默认立即加载
        ScopeLazy scopeLazyOne=ap.getBean("scopeLazyOne", ScopeLazy.class);
        System.out.println("***********");
        System.out.println(scopeLazyOne);
        System.out.println("***********");
        //在创建IOC容器时立即加载Bean
        /*System.out.println("***********");
        ScopeLazy scopeLazyTwo=ap.getBean("scopeLazyTwo", ScopeLazy.class);
        System.out.println(scopeLazyTwo);
        System.out.println("***********");*/

        //延迟加载Bean，在获得Bean时加载
        /*System.out.println("***********");
        ScopeLazy scopeLazyThree=ap.getBean("scopeLazyThree", ScopeLazy.class);
        System.out.println(scopeLazyThree);
        System.out.println("***********");*/

        //多里模式
        /*ScopeLazy scopeLazyFour=ap.getBean("scopeLazyFour", ScopeLazy.class);
        System.out.println("***********");
        System.out.println(scopeLazyFour);
        System.out.println("***********");*/

        ((ConfigurableApplicationContext)ap).close();

    }

}
