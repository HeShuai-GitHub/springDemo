package com.spring.ioc.main_2.annotation.dao.Impl;

import com.spring.ioc.main_2.annotation.dao.AnnotationDao;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.stereotype.Repository;

/**
 * @program: springDemo
 * @description: spring 注解方式配置 Dao 持久层Bean
 * @author: hs
 * @create: 2020-08-13 22:29
 **/
@Repository
public class AnnotationDaoImpl  implements AnnotationDao {

    public AnnotationDaoImpl() {
        System.out.println("AnnotationDaoImpl");
    }
}
