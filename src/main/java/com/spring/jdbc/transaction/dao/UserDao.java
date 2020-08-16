package com.spring.jdbc.transaction.dao;

import com.spring.jdbc.transaction.modal.User;

/**
 * User表Dao层接口
 */
public interface UserDao {

    User query(Integer id);

    void update(Integer id,Double rmb);

}
