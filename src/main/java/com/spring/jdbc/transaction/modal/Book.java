package com.spring.jdbc.transaction.modal;

/**
 * @program: springDemo
 * @description: test_book表的modal类
 * @author: hs
 * @create: 2020-08-16 18:45
 **/
public class Book {

    private Integer id;

    private Double rmb;

    private Integer count;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", rmb=" + rmb +
                ", count=" + count +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRmb() {
        return rmb;
    }

    public void setRmb(Double rmb) {
        this.rmb = rmb;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
