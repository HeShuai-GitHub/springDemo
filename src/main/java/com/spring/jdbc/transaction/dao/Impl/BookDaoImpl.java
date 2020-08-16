package com.spring.jdbc.transaction.dao.Impl;

import com.spring.jdbc.transaction.dao.BookDao;
import com.spring.jdbc.transaction.modal.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @program: springDemo
 * @description: BookDao接口实现类
 * @author: hs
 * @create: 2020-08-16 18:49
 **/
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate dao;

    public Book query(Integer id) {
        String sql="select id,rmb,count from test_book where id= ?";
        RowMapper<Book> row=new BeanPropertyRowMapper(Book.class);
        Book book=dao.queryForObject(sql,new Object[]{id},row);
        return book;
    }

    public void update(Integer id, Integer count) {
        Book book=this.query(id);
        String sql="update test_book set count= ? where id = ?";
        dao.update(sql,book.getCount()-count,id);
    }
}
