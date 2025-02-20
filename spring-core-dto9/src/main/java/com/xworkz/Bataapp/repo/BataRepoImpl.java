package com.xworkz.Bataapp.repo;

import com.xworkz.Bataapp.entity.BataEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


@Component
public class BataRepoImpl implements BataRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(BataEntity bataEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bataEntity);
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
    public BataEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(BataEntity.class, id);
    }

    @Override
    public void getByType(String shoe_type) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery("getByType");
        query.setParameter("type", shoe_type);
        try {
            BataEntity bataEntity = (BataEntity) query.getSingleResult();
            System.out.println(bataEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public BataEntity updatePriceByType(double price, String shoe_type) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("updatePriceByType");
        query.setParameter("price", price);
        query.setParameter("type", shoe_type);
        query.executeUpdate();
        entityManager.getTransaction().commit();

        Query updatedquery = entityManager.createNamedQuery("getByType");
        updatedquery.setParameter("type", shoe_type);

        try {
            BataEntity bataEntity = (BataEntity) updatedquery.getSingleResult();
            System.out.println(bataEntity);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void removeById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BataEntity bataEntity = entityManager.find(BataEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(bataEntity);
        entityManager.getTransaction().commit();
    }
}
