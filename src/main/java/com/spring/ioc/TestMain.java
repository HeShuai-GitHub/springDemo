package com.spring.ioc;

import com.spring.ioc.modal.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: 主运行处理类
 * @author: hs
 * @create: 2020-08-11 12:22
 **/
public class TestMain {

    public static void main(String[] args) {
        //获得spring上下文环境
        ApplicationContext ap=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //拿到bean
        Person person = (Person)ap.getBean("person");
        System.out.println(person);
    }
}
