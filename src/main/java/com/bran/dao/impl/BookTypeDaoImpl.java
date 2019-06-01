package com.bran.dao.impl;

import com.bran.dao.BookTypeDao;
import com.bran.domain.BookType;
import com.bran.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BookTypeDaoImpl implements BookTypeDao {
    @Override
    public void addBookType(BookType bookType) {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(bookType);
        } catch (Exception e) {
            transaction.rollback();
        }
        transaction.commit();
        entityManager.close();
    }
}
