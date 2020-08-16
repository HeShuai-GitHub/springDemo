package com.spring.jdbc.transaction.modal;

/**
 * @program: springDemo
 * @description: test_user表modal类
 * @author: hs
 * @create: 2020-08-16 18:43
 **/
public class User {

    private Integer id;

    private String userName;

    private Double rmb;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", rmb=" + rmb +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getRmb() {
        return rmb;
    }

    public void setRmb(Double rmb) {
        this.rmb = rmb;
    }
}
