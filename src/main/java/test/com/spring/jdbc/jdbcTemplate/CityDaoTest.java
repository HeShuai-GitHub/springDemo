package test.com.spring.jdbc.jdbcTemplate; 

import com.spring.jdbc.jdbcTemplate.CityModal;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/** 
* CityDao Tester. 
* 
* @author <Authors name> 
* @since <pre>8�� 16, 2020</pre> 
* @version 1.0 
*/ 
public class CityDaoTest { 

    private JdbcTemplate jdbcTemplate;

    @Before
    public void before() throws Exception {
        ApplicationContext ap=new ClassPathXmlApplicationContext("jdbc/JDBC-Context.xml");
        jdbcTemplate=ap.getBean("jdbcTemplate",JdbcTemplate.class);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 测试JdbcTemplate的query查询方法，queryForObject返回值是一个泛型，较适合查询一条语句
     * query 返回类型为list<T>,返回的是一个数组，所以比较适合返回一组数据
     */
    @Test
    public void query(){
        String sql="select id,title,ownid,sid,shop from wct_city ";
        RowMapper<CityModal> rowMapper=new BeanPropertyRowMapper<CityModal>(CityModal.class);
        List<CityModal> list=jdbcTemplate.query(sql,rowMapper);
        for(CityModal city:list){
            System.out.println(city);
        }
        System.out.println("*************************");
        sql="select id,title,ownid,sid,shop from wct_city where id= ?";
        CityModal cityModal=jdbcTemplate.queryForObject(sql,new Object[]{1},rowMapper);
        System.out.println(cityModal);
    }

    /**
     * jdbcTemplate.update方法，可以对数据库做增删改操作
     * jdbcTemplate的编码格式可能和数据库的编码格式出现不一致的情况，
     * 所以需要在数据连接的url后面添加“characterEncoding=utf8”
     * 如：jdbc:mysql://localhost:3306/usrdel?characterEncoding=utf8
     */
    @Test
    public void update(){
        String sql="update wct_city set title= ? where id= ?";
        jdbcTemplate.update(sql,"秦皇岛","1");
    }

    /**
     * jdbcTemplate.update 对数据库进行添加操作
     */
    @Test
    public void insert(){
        String sql="insert wct_city values(null,?,?,?,?)";
        jdbcTemplate.update(sql,"唐山","1","2","3");
    }

    /**
     * jdbcTemplate.update 对数据库进行删除操作
     */
    @Test
    public void delete(){
        String sql="delete from wct_city where title=?";
        jdbcTemplate.update(sql,"唐山");
    }


} 
