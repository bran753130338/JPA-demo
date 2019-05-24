package com.bran.dao;

import com.bran.domain.User;

public interface UserDao {
    void addUser(User user);

    User getUser(String name);
}
