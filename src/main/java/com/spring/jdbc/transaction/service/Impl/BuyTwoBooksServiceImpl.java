package com.spring.jdbc.transaction.service.Impl;

import com.spring.jdbc.transaction.service.BuyBookService;
import com.spring.jdbc.transaction.service.BuyTwoBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: springDemo
 * @description: 购买两本书，以此来测试事务的传播性，也就是@Transactional的Propagation属性
 * @author: hs
 * @create: 2020-08-16 20:39
 **/
@Transactional //对该类中的所有方法起作用
@Service
public class BuyTwoBooksServiceImpl implements BuyTwoBooksService {

    @Autowired
    private BuyBookService buyBookService;

    public void buyTwoBooks() {
        System.out.println("购买两本书    开始");
        System.out.println("购买第一本书  开始");
        buyBookService.buyBook();
        System.out.println("购买第一本书  结束");
        System.out.println("***************");
        System.out.println("购买第二本书  开始");
        buyBookService.buyBook();
        System.out.println("购买第二本书  结束");
        System.out.println("购买两本书    结束");
    }
}
