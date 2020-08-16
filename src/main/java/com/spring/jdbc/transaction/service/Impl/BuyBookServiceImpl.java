package com.spring.jdbc.transaction.service.Impl;

import com.spring.jdbc.transaction.dao.BookDao;
import com.spring.jdbc.transaction.dao.UserDao;
import com.spring.jdbc.transaction.modal.Book;
import com.spring.jdbc.transaction.modal.User;
import com.spring.jdbc.transaction.service.BuyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;

/**
 * @program: springDemo
 * @description: BuyBookService实现类
 * @author: hs
 * @create: 2020-08-16 19:02
 **/
@Service
public class BuyBookServiceImpl implements BuyBookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    /**
     * 购买书籍,若不设置事务处理，会产生什么效果呢，可以将@Transaction注解注释后，看一下效果，会造成
     * book表中的库存含量减少了一本书，而user表中的用户余额因为不足，而导致扣款失败，这样就影响了事务中的一致性
     *
     *@Transactional 标注该方法整体为一个事务，需要满足事务的原子性，该标签底层使用aop的思想，也就是动态代理，
     * 所以在spring ioc容器中管理的实际上是代理类，该注解可以在方法上，可以在类上，如果在类上表示类中所有方法都需要满足事务的一致性
     * @Transactional 的参数介绍
     * propagation: A方法和B方法同时具备事务，A方法调用B方法时，会将A方法的事务传递给B方法，B方法对于事务的处理方式就是事务的传播性（propagation）
     *              Propagation.REQUIRED：默认该值，即当A方法调用B方法时，当A方法具备事务，则B方法不会创建事务，否则B方法创建一个新的事务，在自己的事务中运行（常用）
     *以下不举例A、B两个方法了，传播性就是多个事务之间的交互
     *              Propagation.REQUIRES_NEW：当前的方法必须启动新事物，并在他的事务内运行，如果有事务正在运行，则将它挂起（常用）
     *              Propagation.SUPPORTS：如果有事务正在运行，则当前方法就在事务中运行，否则当前方法不在事务中运行
     *              Propagation.NOT_SUPPORTED：当前方法不应该运行在事务中，如果有运行的事务，则将它挂起
     *              Propagation.MANDATORY：当前的方法必须运行在事务内部，如果没有事务，则抛出异常
     *              Propagation.NEVER：当前的方法不应该运行在事务中，如果有运行的事务，则抛出异常
     *              Propagation.NESTED：如果有运行的事务，当前的方法应该在运行的这个事务的嵌套事务中运行，如果没有，就启动一个新事物，并在自己的事务中运行
     *
     * isolation: 事务的隔离级别，这个就不解释了，网上有太多的介绍，也属于关系型数据库基础
     *              Isolation.DEFAULT：根据数据库的默认级别来进行设置
     *             Isolation.READ_UNCOMMITTED：读未提交
     *             Isolation.READ_COMMITTED：读已提交
     *             Isolation.REPEATABLE_READ：可重复读
     *             Isolation.SERIALIZABLE： 串行化
     * timeout：  设置事务超时时间，当事务超时后强制进行回滚操作
     *
     * readOnly： 指定当前事务中的一系列操作是否为只读，并非强制当前方法中只可以包括读操作
     *             readOnly最主要的作用是通知mysql不加锁，以提高数据库的性能
     *             如果readOnly设置为True，但是当前方法中不只包含读操作，还有写操作，在不加锁的情况下，将造成赃读、不可重复读、幻读等问题（需谨慎使用）
     *
     * rollbackFor||rollbackForClassName||noRollbackFor||noRollbackForClassName：设置事务回滚条件，不设置默认发生任何异常都进行回滚
     *              rollbackFor:只有设置的异常才会回滚
     *              noRollbackFor：设置的异常不进行回滚，其他都进行回滚
     *              rollbackForClassName和noRollbackForClassName：基本上上面一致，不过一个是对象参数，一个是类全限定名参数
     */
    @Transactional(rollbackForClassName = {"Exception"})
    public void buyBook() {
        System.out.println("开始购买书籍");
        Book book=bookDao.query(1);
        System.out.println("书籍价格为："+book.getRmb()+"，书籍库存："+book.getCount());
        //对编号为1的书籍，购买一本
        bookDao.update(1,1);
        book=bookDao.query(1);
        User user=userDao.query(1);
        System.out.println("购买书籍的人是："+user.getUserName()+"，账户余额："+user.getRmb());
        if(user.getRmb()<book.getRmb()){
            throw new RuntimeException("用户账户余额不足...\n"+"现在书籍库存是："+book.getCount()+"，账户余额："+user.getRmb()
            +"，\n如果标记了@Transactional，他将在发生异常后发生回滚，数据库数据不变");
        }
        userDao.update(1,book.getRmb());
        user=userDao.query(1);
        System.out.println("购买书籍结束");
        System.out.println("现在书籍库存是："+book.getCount()+"，账户余额："+user.getRmb());
    }
}
