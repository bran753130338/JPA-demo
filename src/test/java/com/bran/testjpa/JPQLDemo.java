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
}
