package com.bran.testjpa;

import com.bran.domain.User;
import com.bran.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPQL2Demo {

    //使用JPQL语句更新操作
    @Test
    public void fun1(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        //更新操作需要开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "update User user set user.name = :uname where user.id = :uid";
        //也可以不使用别名
        //String jpql2 = "update User set name = :uname where id = :uid";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("uname","坤坤");
        query.setParameter("uid",1);
        try {
            query.executeUpdate();
        }catch (Exception e){
            transaction.rollback();
        }
        transaction.commit();
        entityManager.close();
    }

    //使用JPQL语句删除操作
    @Test
    public void fun2(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String jpql = "delete from User user where user.id = :uid";

        Query query = entityManager.createQuery(jpql);
        query.setParameter("uid",4);

        try {
            query.executeUpdate();
        }catch (Exception e){
            transaction.rollback();
        }
        transaction.commit();
        entityManager.close();
    }

    //使用JPQL语句分页操作
    @Test
    public void fun3(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        String jpql = "select user from User user";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        //设置起始位置，第一条记录是从0开始
        query.setFirstResult(1);
        //设置每页大小(显示数据的多少)
        query.setMaxResults(2);
        List<User> resultList = query.getResultList();
        for (User user : resultList) {
            System.out.println(user);
        }
        entityManager.close();
    }

    //使用JPQL语句查询总记录数
    @Test
    public void fun4(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        String jpql = "select count(user.id) from User user";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        Long result = query.getSingleResult();
        System.out.println(result);
        entityManager.close();
    }
}
