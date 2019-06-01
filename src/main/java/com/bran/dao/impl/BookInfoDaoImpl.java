package com.bran.dao.impl;

import com.bran.dao.BookInfoDao;
import com.bran.domain.BookInfo;
import com.bran.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BookInfoDaoImpl implements BookInfoDao {


    @Override
    public void addBookInfo(BookInfo bookInfo) {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(bookInfo);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        transaction.commit();
        entityManager.close();
    }
}
