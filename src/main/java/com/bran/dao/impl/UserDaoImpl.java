package com.bran.dao.impl;

import com.bran.dao.UserDao;
import com.bran.domain.User;
import com.bran.utils.JPAUtils;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        // Persistence.createEntityManagerFactory("jpa-1")中的jpa-1是核心配置文件persistence.xml中的持久化单元名称
        //1.加载配置，得到工厂
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-1");
        //2.得到实体管理对象
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //4.操作数据
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            transaction.rollback();
        }
        //5.提交事务
        transaction.commit();
        //6.关闭连接
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public User findById(Integer id) {
        EntityManager entityManager = JPAUtils.getEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    @Override
    public User updateUser(Integer id, String name) {
        User user = null;
        //1.加载配置，得到工厂
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-1");
        //2.得到实体管理对象
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //4.操作数据
        try {
            user = entityManager.find(User.class, id);
            user.setName(name);
            entityManager.merge(user);
        } catch (Exception e) {
            transaction.rollback();
        }
        //5.提交事务
        transaction.commit();
        //6.关闭连接
        entityManager.close();
        entityManagerFactory.close();
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        //1.加载配置，得到工厂
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-1");
        //2.得到实体管理对象
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //4.操作数据
        try {
            //注意：删除必须在同样一个实体管理对象才可以，一个entityManager查，一个新的entityManager删除会失败
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
        } catch (Exception e) {
            transaction.rollback();
        }
        //5.提交事务
        transaction.commit();
        //6.关闭连接
        entityManager.close();
        entityManagerFactory.close();
    }


}
