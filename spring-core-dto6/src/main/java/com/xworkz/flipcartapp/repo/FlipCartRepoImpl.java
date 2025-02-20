package com.xworkz.flipcartapp.repo;

import com.xworkz.flipcartapp.entity.FlipCartEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
public class FlipCartRepoImpl implements FlipCartRepo {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(FlipCartEntity flipCartEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(flipCartEntity);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return false;
        } finally {
            entityManager.close();
            emf.close();
        }
    }

    @Override
    public FlipCartEntity getById(Integer id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(FlipCartEntity.class, id);

    }

    @Override
    public Void getByName(String state_name) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery("getDataByName");
        query.setParameter("productName", state_name);
        try {
            FlipCartEntity singleResult = (FlipCartEntity) query.getSingleResult();
            System.out.println(singleResult);

        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public FlipCartEntity updateCostByName(String product_Name, Integer cost) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateCostByName");
            query.setParameter("productName", product_Name);
            query.setParameter("cost", cost);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query updatedQuery = entityManager.createNamedQuery("getDataByName");
            updatedQuery.setParameter("name", product_Name);
            FlipCartEntity flipCartEntity = (FlipCartEntity) updatedQuery.getSingleResult();
            return flipCartEntity;


        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void removeBYId(Integer id) {
        EntityManager entityManager = emf.createEntityManager();
        FlipCartEntity stateEntity = entityManager.find(FlipCartEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(stateEntity);
        entityManager.getTransaction().commit();

    }

}


