package com.spring.ioc.modal;

/**
 * @program: springDemo
 * @description: 测试modal类
 * @author: hs
 * @create: 2020-08-11 12:21
 **/
public class Person {

    private Integer id;

    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", dog=" + dog +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
