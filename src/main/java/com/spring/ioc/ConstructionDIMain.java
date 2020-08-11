package com.spring.ioc;

import com.spring.ioc.modal.Dog;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: spring构造方法注入方式
 * @author: hs
 * @create: 2020-08-11 18:07
 **/
public class ConstructionDIMain {

    public static void main(String[] args) {
        ApplicationContext ap=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Dog dog=ap.getBean("dogTwo", Dog.class);
        System.out.println(dog);

    }

}
