package com.spring.ioc.main_1;

import com.spring.ioc.modal.LifeCircle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: 后置处理器Main
 * @author: hs
 * @create: 2020-08-12 14:51
 **/
public class Seven_AfterHandleMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext ca=new ClassPathXmlApplicationContext("AfterHandle-Context.xml");
        LifeCircle lifeCircle=ca.getBean("lifeCircle", LifeCircle.class);
        System.out.println(lifeCircle);
        ca.close();
    }

}
