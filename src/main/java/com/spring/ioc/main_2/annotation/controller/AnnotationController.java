package com.spring.ioc.main_2.annotation.controller;

import com.spring.ioc.main_2.annotation.service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.concurrent.TimeUnit;

/**
 * @program: springDemo
 * @description: spring 注解方法装配Bean的方式 控制层
 * @author: hs
 * @create: 2020-08-13 22:24
 **/
@Controller
public class AnnotationController {
    /**
     * @AutoWired 默认根据byType方式在spring ioc容器中注入bean，IOC容器内不可以包含两个可以配置类型的bean，如果有多个可以配合
     * @Qualifier使用，@Qualifier可以根据ioc中的id指定bean，具体配合例子可参考百度
     */

    @Autowired
    private AnnotationService annotationService;

    public AnnotationController() {
        System.out.println("AnnotationController");
        //启动线程延迟调用getString()方法
        new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(annotationService.getString());
            }
        }).start();
    }
}
