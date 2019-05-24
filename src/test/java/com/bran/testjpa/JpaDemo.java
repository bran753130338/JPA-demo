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
    public void fun2(){
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findById(1);
        System.out.println(user);
    }
}
