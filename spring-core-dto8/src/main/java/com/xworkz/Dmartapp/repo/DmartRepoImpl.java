package com.xworkz.Dmartapp.repo;

import com.xworkz.Dmartapp.entity.DmartEntity;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


@Component

public class DmartRepoImpl implements DmartRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(DmartEntity dmartEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(dmartEntity);
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
    public DmartEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(DmartEntity.class, id);
    }

    @Override
    public void getByLocation(String location) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery("getBylocation");
        query.setParameter("location", location);
        try {
            DmartEntity dmartEntity = (DmartEntity) query.getSingleResult();
            System.out.println(dmartEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public DmartEntity updateEmployeeByLocation(Integer no_Of_Employees, String location) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateEmployeesByLocation");
            query.setParameter("noOfEmployees", no_Of_Employees);
            query.setParameter("location", location);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query query1 = entityManager.createNamedQuery("getBylocation");
            query1.setParameter("location", location);
            DmartEntity dmartEntity = (DmartEntity) query1.getSingleResult();
            System.out.println(dmartEntity);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void removeById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        DmartEntity dmartEntity = entityManager.find(DmartEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(dmartEntity);
        entityManager.getTransaction().commit();
    }
}
