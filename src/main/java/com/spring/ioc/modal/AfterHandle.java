package com.spring.ioc.modal;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @program: springDemo
 * @description: 后置处理器测试
 * @author: hs
 * @create: 2020-08-12 14:40
 **/
public class AfterHandle implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Three Before：初始化之前进行的操作");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Three After：初始化之后进行的操作");
        LifeCircle lifeCircle=(LifeCircle) bean;
        if(lifeCircle.getName().equals("钟馗")){
            lifeCircle.setSex("男");
        }else{
            lifeCircle.setSex("女");
        }
        return bean;
    }
}
