package com.spring.aop.proxy.static1;

import com.spring.aop.aspectj.HelloInterface;

/**
 * @program: springDemo
 * @description: 静态代理模块主main，代理类主要负责为委托了（真实对象）预处理消息、过滤消息、传递消息给委托类，
 * 代理类不现实具体服务，而是利用委托类来完成服务，并将执行结果封装处理。其实就是代理类为被代理类预处理消息、
 * 过滤消息并在此之后将消息转发给被代理类，之后还能进行消息的后置处理。代理类和被代理类通常会存在关联关系(即上面提到的持有的被带离对象的引用)，
 * 代理类本身不实现服务，而是通过调用被代理类中的方法来提供服务。
 * 说的简单点就是，代理类包装了被代理类，通过执行代理类来执行被代理类，因此代理类可以添加一些固有操作
 * @author: hs
 * @create: 2020-08-14 15:44
 **/
public class ProxyMain {

    /**
     * 实际业务代码在HelloImpl中，它是委托类，也是实际应该执行的代码，HelloProxy是代理类，它的作用就是代替HelloImpl去做某件事，但是
     * 为了最后结果和预期结果是一致的，所以以间接调用了委托类的形式来完成这件事情
     *
     * @param args
     */
    public static void main(String[] args) {
        HelloInterface hello=new HelloProxy();
        hello.sayHello();
    }

}
