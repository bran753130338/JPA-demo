package com.bran.dao;

import com.bran.domain.BookType;

public interface BookTypeDao {

    //添加新类型
    void addBookType(BookType bookType);

    //通过主键查找对象
    BookType findById(Long typeId);
}
