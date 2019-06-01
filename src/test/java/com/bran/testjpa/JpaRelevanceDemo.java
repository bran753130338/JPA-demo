package com.bran.testjpa;

import com.bran.dao.BookTypeDao;
import com.bran.dao.impl.BookTypeDaoImpl;
import com.bran.domain.BookType;
import org.junit.Test;


/**
 * JPA关联测试类
 */
public class JpaRelevanceDemo {

    @Test
    public void fun(){
        BookTypeDao bookTypeDao = new BookTypeDaoImpl();
        BookType bookType = new BookType();
        bookType.setTyprName("计算机");
        bookType.setTypeDesc("与计算机相关的书籍");
        bookTypeDao.addBookType(bookType);
    }

}
