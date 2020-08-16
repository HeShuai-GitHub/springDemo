package com.spring.jdbc.jdbcTemplate;

/**
 * @program: springDemo
 * @description: 城市信息modal类
 * @author: hs
 * @create: 2020-08-16 15:30
 **/
public class CityModal {

    private String id;

    private String title;

    private String sid;

    private String shop;



    @Override
    public String toString() {
        return "CityModal{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", sid='" + sid + '\'' +
                ", shop='" + shop + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
}
