package com.spring.ioc.main_1;

import com.spring.ioc.modal.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: 工厂Bean测试运行Main
 * @author: hs
 * @create: 2020-08-12 11:47
 **/
public class Five_FactoryMain {

    public static void main(String[] args) {
        ApplicationContext ap=new ClassPathXmlApplicationContext("FactoryBean-Context.xml");
        //获得工厂Bean，获得的实例化对象是工厂所生产的Bean对象
        Dog dog=(Dog)ap.getBean("factory");
        System.out.println(dog);
    }

}
