package com.spring.ioc.modal;

/**
 * @program: springDemo
 * @description: Bean声明周期测试
 * @author: hs
 * @create: 2020-08-12 14:43
 **/
public class LifeCircle {


    private String name;

    private String sex;

    public LifeCircle() {
        System.out.println("One：创建Bean");

    }

    @Override
    public String toString() {
        System.out.println("Four：进行若干操作");
        return "LifeCircle{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        System.out.println("Two：注入依赖");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void init(){
        System.out.println("Three：初始化");
    }

    public void destroy(){
        System.out.println("Five：注销");
    }

}
