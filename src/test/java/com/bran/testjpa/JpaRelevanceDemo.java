package com.bran.testjpa;

import com.bran.dao.BookInfoDao;
import com.bran.dao.BookTypeDao;
import com.bran.dao.impl.BookInfoDaoImpl;
import com.bran.dao.impl.BookTypeDaoImpl;
import com.bran.domain.BookInfo;
import com.bran.domain.BookType;
import org.junit.Test;


/**
 * JPA关联测试类
 */
public class JpaRelevanceDemo {

    @Test
    public void fun1(){
        BookTypeDao bookTypeDao = new BookTypeDaoImpl();
        BookType bookType = new BookType();
        bookType.setTyprName("计算机");
        bookType.setTypeDesc("与计算机相关的书籍");
        bookTypeDao.addBookType(bookType);
    }

    @Test
    public void fun2(){
        BookInfoDao bookInfoDao = new BookInfoDaoImpl();
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("Node.js实战");
        bookInfo.setBookAuthor("Alex Young");
        bookInfo.setBookDesc("Node.js的实战教程");
        bookInfo.setBookPublish("人民邮电出版社");
        bookInfo.setBookPrice(89.00D);
        bookInfo.setBookDate(2018L);
        //获得对象，关联对象
        BookType bookType = new BookTypeDaoImpl().findById(1L);
        bookInfo.setBookType(bookType);
        bookInfoDao.addBookInfo(bookInfo);
    }

}
