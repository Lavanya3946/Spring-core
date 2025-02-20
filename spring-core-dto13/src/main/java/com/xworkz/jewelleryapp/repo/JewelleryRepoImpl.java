package com.xworkz.jewelleryapp.repo;

import com.xworkz.jewelleryapp.entity.JewelleryEntity;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class JewelleryRepoImpl implements JewelleryRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(JewelleryEntity jewelleryEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(jewelleryEntity);
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
    public JewelleryEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(JewelleryEntity.class, id);
    }

    @Override
    public void getByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getByName");
        query.setParameter("name", name);
        try {
            JewelleryEntity jewelleryEntity = (JewelleryEntity) query.getSingleResult();
            System.out.println(jewelleryEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTypeByName(String type, String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("updateTypeByName");
        query.setParameter("type", type);
        query.setParameter("name", name);
        query.executeUpdate();
        entityManager.getTransaction().commit();

        Query updated = entityManager.createNamedQuery("getByName");
        updated.setParameter("name", name);
        try {
            JewelleryEntity jewelleryEntity = (JewelleryEntity) updated.getSingleResult();
            System.out.println(jewelleryEntity);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        JewelleryEntity jewelleryEntity = entityManager.find(JewelleryEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(jewelleryEntity);
        entityManager.getTransaction().commit();
    }
}
