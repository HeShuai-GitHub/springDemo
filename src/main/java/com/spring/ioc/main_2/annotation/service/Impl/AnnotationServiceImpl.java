package com.spring.ioc.main_2.annotation.service.Impl;

import com.spring.ioc.main_2.annotation.service.AnnotationService;
import org.springframework.stereotype.Service;

/**
 * @program: springDemo
 * @description: spring 注解方式配置 service业务逻辑层
 * @author: hs
 * @create: 2020-08-13 22:27
 **/
@Service
public class AnnotationServiceImpl implements AnnotationService {

    public AnnotationServiceImpl() {
        System.out.println("AnnotationServiceImpl");
    }

    public String getString() {
        return "获得：AnnotationServiceImpl";
    }
}
