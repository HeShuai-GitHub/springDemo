package com.spring.jdbc.transaction.dao;

import com.spring.jdbc.transaction.modal.Book;
import com.spring.jdbc.transaction.modal.User;

/**
 * book表Dao层接口
 */
public interface BookDao {

    Book query(Integer id);

    void update(Integer id,Integer count);
}


