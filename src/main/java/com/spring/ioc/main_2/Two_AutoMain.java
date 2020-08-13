package com.spring.ioc.main_2;

import com.spring.ioc.modal.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: 自动装配测试main
 * @author: hs
 * @create: 2020-08-12 22:27
 **/
public class Two_AutoMain {

    public static void main(String[] args) {
        ApplicationContext ap=new ClassPathXmlApplicationContext("AutoWire-Context.xml");
        Person personOne=ap.getBean("personOne",Person.class);
        System.out.println(personOne);
        Person personTwo=ap.getBean("personTwo",Person.class);
        System.out.println(personTwo);
        Person personThree=ap.getBean("personThree",Person.class);
        System.out.println(personThree);

    }

}
