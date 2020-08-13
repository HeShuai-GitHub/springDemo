package com.spring.ioc.main_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

/**
 * @program: springDemo
 * @description: spring jdbc 连接数据库
 * @author: hs
 * @create: 2020-08-12 20:42
 **/
public class One_JDBCMain {

    public static void main(String[] args) throws Exception{
        ApplicationContext ap=new ClassPathXmlApplicationContext("jdbc/JDBC-Context.xml");
        /*使用原始的连接*/
        /*DriverManagerDataSource dataSource=ap.getBean("dataSource",DriverManagerDataSource.class);
        System.out.println(dataSource.getConnection());*/
        JdbcTemplate jt = (JdbcTemplate)ap.getBean("jdbcTemplate");
        List<Map<String, Object>> list = jt.queryForList("select * from sys_user");
        System.out.println(list);
    }

}
