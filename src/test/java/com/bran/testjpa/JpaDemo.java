package com.bran.testjpa;

import com.bran.dao.UserDao;
import com.bran.dao.impl.UserDaoImpl;
import com.bran.domain.User;
import org.junit.Test;



public class JpaDemo {

    //添加用户测试
    @Test
    public void fun1() {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setName("吴亦凡");
        user.setEmail("123456@example.com");
        userDao.addUser(user);
    }

    //查找用户测试
    @Test
    public void fun2() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findById(1);
        System.out.println(user);
    }

    //修改用户信息
    @Test
    public void fun3() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.updateUser(1, "张帅");
        System.out.println(user);
    }

    //删除用户信息
    @Test
    public void fun4(){
        UserDao userDao = new UserDaoImpl();
        userDao.deleteUser(1);
    }
}
