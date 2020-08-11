package com.spring.ioc.modal;

/**
 * @program: springDemo
 * @description: 测试modal类
 * @author: hs
 * @create: 2020-08-11 16:17
 **/
public class Dog {

    private String name;

    private String color;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Dog() {
    }

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
