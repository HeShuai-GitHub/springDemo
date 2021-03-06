package com.spring.ioc.modal;

import java.util.Map;

/**
 * @program: springDemo
 * @description: 测试modal类
 * @author: hs
 * @create: 2020-08-11 12:21
 **/
public class Person {

    private Integer id;

    private Dog dog;

    private Animal animal;

    private Map<String,String> possess;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", dog=" + dog +
                ", animal=" + animal +
                ", possess=" + possess +
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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Map<String, String> getPossess() {
        return possess;
    }

    public void setPossess(Map<String, String> possess) {
        this.possess = possess;
    }
}
