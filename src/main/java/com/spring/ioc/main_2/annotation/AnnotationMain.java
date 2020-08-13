package com.spring.ioc.main_2.annotation;

import com.spring.ioc.main_2.annotation.service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springDemo
 * @description: spring 注解配置bean的Main
 * @author: hs
 * @create: 2020-08-13 22:31
 **/
public class AnnotationMain {


    public static void main(String[] args) {
        //加载spring容器
        ApplicationContext ap=new ClassPathXmlApplicationContext("annotation/Annotation-Context.xml");
    }

}
