package com.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: springDemo
 * @description: 切面，aspectj是对spring aop的最好实现，是以注解的方式进行实现的
 * spring 原生aop是以xml的方式进行实现的
 * 切面：封装横切关注点的类，每个关注点都体现一个通知方法，动态代理概念中的代理类；
 * @author: hs
 * @create: 2020-08-14 22:43
 **/
@Component //使该类被spring ioc容器加载管理
@org.aspectj.lang.annotation.Aspect //指定被标记类为切面，即动态代理中的代理类
public class Aspect {


    /**
     * @Around 标记该方法为环绕通知，注解内value参数为切入点表达式
     * 环绕通知基本等同于动态代理中的实现InvocationHandler的invoke方法，所以应用较少
     * @ProceedingJoinPoint 可以用这个参数来调用目标对象
     * @return 一定要有返回值，这个就相当于动态代理的返回值，如果缺少返回值，相当于调用过程没有完成
     */
    @Around("execution(* com.spring.aop.*.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        try{
            //@Before 此位置的代码等同于前置通知的作用
            System.out.println("前置通知");
            Object result=joinPoint.proceed();
            //@AfterReturning 此位置的代码等同于返回通知的作用
            System.out.println("返回通知");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //@AfterThrowing 此位置的代码等同于异常通知的作用
            System.out.println("异常通知");
        }finally {
            //@After 此位置的代码等同于后置通知的作用
            System.out.println("后置通知");
        }
        return null;
    }

    /**
     * @Before 标记该方法为前置通知，注解内value参数为切入点表达式
     * 这个是必须设置的，指定切入规则
     * 切入点表达式：
     *    *：可以表示public void（返回值和范围修饰符），某个包、某个类; 注：一个*表示一个包，不可以表示多个包
     *    ..:表示任意的形参形式
     * @JoinPoint 连接点，即切面切入后的具体位置，JoinPoint中包含目标对象的一些基本信息，包括参数，类名、方法名等
     */
    //@Before("execution(public void com.spring.aop.aspectj.HelloImpl.sayHello())")
    @Before("execution(* com.spring.*.*.*.*(..))")
    public void before(JoinPoint joinPoint){
        //获得连接点所在的参数列表
        Object[] objects=joinPoint.getArgs();
        // 声明的className,即全限定名
        String className=joinPoint.getSignature().getDeclaringTypeName();
        //方法名
        String methodName=joinPoint.getSignature().getName();
        System.out.println("Before "+className+":"+methodName+"   参数："+ Arrays.toString(objects));
    }

    /**
     * @After 标记该方法为后置通知，作用于方法运行最后，通常用来关闭一些必要的资源
     * 不管目标对象是否发生异常都会执行后置通知，即动态代理中的finally语句块
     */
    @After("execution(* com.spring.aop.*.*.*(..))")
    public void after(){
        System.out.println("后置通知");
    }

    /**
     * @AfterReturning 标记该方法为返回通知，作用于方法正常返回之后，输出一些运行结果，
     * 若目标对象发生异常，将不执行返回通知
     * returning 声明一个返回值参数，需要在返回通知方法的形参中声明同名参数，以此来接受目标对象运行结果
     */
    @AfterReturning(value = "execution(* com.spring.aop.*.*.*(..))",returning = "returnM")
    public void afterReturning(Object returnM){
        System.out.println("返回通知，结果："+returnM);
    }

    /**
     * @AfterThrowing 标记该方法为异常通知，作用于方法发生异常时，做一些对异常处理的操作
     * 相当于 动态代理中的catch语句块
     * throwing 声明一个异常参数，需要在异常通知的形参中声明同名参数，来接受目标对象在运行过程中发生的异常
     * 可以通过定义不同类型的异常类，如：Exception、PointNullException来指定异常通知需要处理的异常类型
     */
    @AfterThrowing(value = "execution(* com.spring.aop.*.*.*(..))",throwing = "message")
    public void afterThrowing(Exception message){
        System.out.println("异常通知，异常："+message);
    }

}
