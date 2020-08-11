package com.spring.ioc;

import com.spring.ioc.modal.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @program: springDemo
 * @description: 获取springIOC容器的多种方式
 * @author: hs
 * @create: 2020-08-11 12:22
 **/
public class GetMutiIOCMain {

    public static void main(String[] args) {
        //获得spring上下文环境，即IOC容器，它的顶级实现接口是BeanFactory
        //ClassPathXmlApplicationContext和FileSystemXmlApplicationContext都是实现类
        //ClassPathXmlApplicationContext对应的是相对路径，获取的是项目中的配置文件
        //FileSystemXmlApplicationContext的参数是绝对路径，可以获取其他服务器存储的配置文件
        ApplicationContext ap=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ApplicationContext apFile=new FileSystemXmlApplicationContext("E:\\programfile\\ideaj-file\\demo\\springDemo\\src\\main\\resources\\ApplicationContext.xml");
        //拿到bean
        Person person = (Person)apFile.getBean("person");
        System.out.println(person);
        //ConfigurableApplicationContext是 ApplicationContext的下一级继承接口，拥有close方法，可用来关闭打开的文件资源
        //可通过Ctrl+T和Ctrl+Alt+U来查看他们的继承关系（eclipse快键键）
        //Ctrl+T 查看该类的所有子类以及实现类
        //Ctrl+Alt+U 查看该类上级所有类的继承关系
        ConfigurableApplicationContext ca=(ConfigurableApplicationContext)apFile;
        ca.close();
    }
}
