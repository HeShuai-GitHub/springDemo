package com.spring.ioc.modal;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: springDemo
 * @description: 工厂bean的创建，工厂模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
 * @author: hs
 * @create: 2020-08-12 11:33
 **/
public class FactoryBeanTest implements FactoryBean<Dog> {

    public Dog getObject() throws Exception {
        Dog dog=new Dog();
        dog.setName("whi");
        dog.setColor("white");
        return dog;
    }

    public Class<?> getObjectType() {
        return Dog.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
