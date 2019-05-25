package com.bran.dao;

import com.bran.domain.User;

public interface UserDao {
    //添加用户
    void addUser(User user);

    //通过id查找用户
    User findById(Integer id);

    //更新用户名称
    User updateUser(Integer id,String name);

    //删除用户
    void deleteUser(Integer id);



}
