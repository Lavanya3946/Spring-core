package com.xworkz.cosmeticsapp.repo;

import com.xworkz.cosmeticsapp.entity.CosmeticsEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class CosmeticsRepoImpl implements CosmeticsRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(CosmeticsEntity cosmeticsEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cosmeticsEntity);
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
    public CosmeticsEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(CosmeticsEntity.class, id);
    }

    @Override
    public void getByBrand(String brand) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getByName");
        query.setParameter("brand", brand);
        try {
            CosmeticsEntity cosmeticsEntity = (CosmeticsEntity) query.getSingleResult();
            System.out.println(cosmeticsEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateCostByType(Integer cost, String type) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateCostByType");
            query.setParameter("cost", cost);
            query.setParameter("type", type);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query updatedquery = entityManager.createNamedQuery("getByType");
            updatedquery.setParameter("type", type);

            CosmeticsEntity cosmeticsEntity = (CosmeticsEntity) updatedquery.getSingleResult();
            System.out.println(cosmeticsEntity);
        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();

        }


    }

    @Override
    public void removeById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CosmeticsEntity cosmeticsEntity = entityManager.find(CosmeticsEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(cosmeticsEntity);
        entityManager.getTransaction().commit();
    }
}
