package com.bran.testjpa;

import com.bran.domain.User;
import com.bran.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPQLDemo {

    //JPQL查询语句
    @Test
    public void fun1(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        String jpql = "from User";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        List<User> resultList = query.getResultList();
        for (User user : resultList) {
            System.out.println(user);
        }
        entityManager.close();
    }
    //JPQL查询:参数查询
    @Test
    public void fun2(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        //参数名前必须冠以冒号(:)
        String jpql = "select user from User user where user.id = :id";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("id",1);
        User user = query.getSingleResult();
        System.out.println(user);
        entityManager.close();
    }
    //JPQL查询:占位符
    @Test
    public void fun3(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        String jpql = "select user from User user where user.id = ?1 and user.name = ?2";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        //?1代表第一个参数
        query.setParameter(1,1);
        //?2代表第二个参数
        query.setParameter(2,"吴亦凡");
        User user = query.getSingleResult();
        System.out.println(user);
        entityManager.close();
    }
    //JPQL查询:模糊查询
    @Test
    public void fun4(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        String jpql = "select user from User user where user.email like ?1";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter(1,"%@example.com");
        List<User> resultList = query.getResultList();
        for (User user : resultList) {
            System.out.println(user);
        }
        entityManager.close();
    }
    //JPQL查询:投影查询(查询部分字段)
    @Test
    public void fun5(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        String jpql = "select user.name,user.email from User user";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList) {
            System.out.println(objects[0]+"\t"+objects[1]);
        }
        entityManager.close();
    }
}
