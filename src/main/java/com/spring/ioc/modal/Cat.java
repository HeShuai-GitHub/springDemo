package com.spring.ioc.modal;

/**
 * @program: springDemo
 * @description: 测试类
 * @author: hs
 * @create: 2020-08-12 22:32
 **/
public class Cat implements Animal{

    private String cat;

    @Override
    public String toString() {
        return "Cat{" +
                "cat='" + cat + '\'' +
                '}';
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
