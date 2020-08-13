package com.spring.ioc.main_1;

import com.spring.ioc.modal.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: p和c命名空间main
 * @author: hs
 * @create: 2020-08-11 22:35
 **/
public class Three_PAndCMain {

    public static void main(String[] args) {

        ApplicationContext ap=new ClassPathXmlApplicationContext("PAndCForNamespace.xml");
        Person person=ap.getBean("person", Person.class);
        System.out.println(person);
    }

}
