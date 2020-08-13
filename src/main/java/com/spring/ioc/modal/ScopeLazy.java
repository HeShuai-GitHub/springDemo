package com.spring.ioc.modal;

import java.text.DateFormat;

/**
 * @program: springDemo
 * @description: 单例多例及延迟与否测试类
 * @author: hs
 * @create: 2020-08-12 12:14
 **/
public class ScopeLazy {


    private String name;

    public ScopeLazy() {
        System.out.println("ScopeLazy  加载");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init(){
        System.out.println("初始化");
    }

    public void destory(){
        System.out.println("销毁");
    }

}
