package test.com.spring.jdbc.transaction.service.Impl;

import com.spring.jdbc.transaction.service.BuyBookService;
import com.spring.jdbc.transaction.service.BuyTwoBooksService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* BuyBookServiceImpl Tester. 
*   Xml配置事务管理方式的实现
 *
* @author <Authors name> 
* @since <pre>8�� 16, 2020</pre> 
* @version 1.0 
*/ 
public class BuyBookTransactionXmlTest {


    private BuyBookService buyBookService;

    private BuyTwoBooksService buyTwoBooksService;

@Before
public void before() throws Exception {
    ApplicationContext ap=new ClassPathXmlApplicationContext("jdbc/JDBC-TransactionXML-Context.xml");
    buyBookService=ap.getBean("buyBookServiceImpl", BuyBookService.class);
    buyTwoBooksService=ap.getBean("buyTwoBooksServiceImpl",BuyTwoBooksService.class);
}

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: buyBook() 
* 
*/ 
@Test
public void testBuyBook() throws Exception {
    buyBookService.buyBook();
} 

@Test
public void testBuyTwoBooks() throws Exception{
    buyTwoBooksService.buyTwoBooks();
}

} 
