package com.bran.dao;

import com.bran.domain.User;

public interface UserDao {
    //添加用户
    void addUser(User user);

    //通过id查找用户
    User findById(Integer id);


}
