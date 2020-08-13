package com.spring.ioc.main_1;

import com.spring.ioc.modal.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: 集合依赖注入Main
 * @author: hs
 * @create: 2020-08-12 00:27
 **/
public class Four_ListMain {

    public static void main(String[] args) {

        ApplicationContext ap=new ClassPathXmlApplicationContext("ListContext.xml");
        Person person=ap.getBean("person", Person.class);
        System.out.println(person);
    }

}
