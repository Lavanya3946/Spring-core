package com.xworkz.bookapp.repo;

import com.xworkz.bookapp.entity.BookEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class BookRepoImpl implements BookRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(BookEntity bookEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bookEntity);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return false;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    @Override
    public BookEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(BookEntity.class, id);
    }

    @Override
    public void getByName(String book_name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getByName");
        query.setParameter("name", book_name);
        try {
            BookEntity bookEntity = (BookEntity) query.getSingleResult();
            System.out.println(bookEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateCostByName(Integer cost, String book_name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateCostByName");
            query.setParameter("cost", cost);
            query.setParameter("name", book_name);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query updatedquery = entityManager.createNamedQuery("getByName");
            updatedquery.setParameter("name", book_name);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public void removeById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BookEntity bookEntity = entityManager.find(BookEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(bookEntity);
        entityManager.getTransaction().commit();
    }
}
