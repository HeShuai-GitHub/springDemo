package com.spring.ioc.modal;

/**
 * @program: springDemo
 * @description: 测试modal类
 * @author: hs
 * @create: 2020-08-11 12:21
 **/
public class Person {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
