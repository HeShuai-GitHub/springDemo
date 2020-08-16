package com.spring.jdbc.transaction.dao.Impl;

import com.spring.jdbc.transaction.dao.UserDao;
import com.spring.jdbc.transaction.modal.Book;
import com.spring.jdbc.transaction.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @program: springDemo
 * @description: UserDao 实现类
 * @author: hs
 * @create: 2020-08-16 18:48
 **/
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate dao;

    public User query(Integer id) {
        String sql="select id,username as userName,rmb from test_user where id= ?";
        RowMapper<User> row=new BeanPropertyRowMapper(User.class);
        User user=dao.queryForObject(sql,new Object[]{id},row);
        return user;
    }

    public void update(Integer id, Double rmb) {
        User user=this.query(id);
        String sql="update test_user set rmb= ? where id = ?";
        dao.update(sql,user.getRmb()-rmb,id);
    }
}
