package com.workz.Zomato.repo;

import com.workz.Zomato.entity.ZomatoEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class ZomatoRepoImpl implements ZomatoRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(ZomatoEntity zomatoEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(zomatoEntity);
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
    public ZomatoEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(ZomatoEntity.class, id);
    }

    @Override
    public void getByName(String food_name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getByName");
        query.setParameter("foodName", food_name);

        try {
            ZomatoEntity zomatoEntity = (ZomatoEntity) query.getSingleResult();
            System.out.println(zomatoEntity);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ZomatoEntity updateCostByName(String food_name, Integer cost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateCostByName");
            query.setParameter("cost", cost);
            query.setParameter("foodName", food_name);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query updated = entityManager.createNamedQuery("getByName");
            updated.setParameter("foodName", food_name);
            ZomatoEntity zomatoEntity = (ZomatoEntity) updated.getSingleResult();
            return zomatoEntity;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    @Override
    public void removeById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ZomatoEntity zomatoEntity = entityManager.find(ZomatoEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(zomatoEntity);
        entityManager.getTransaction().commit();
    }
}
