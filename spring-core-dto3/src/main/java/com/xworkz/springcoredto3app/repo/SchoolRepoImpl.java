package com.xworkz.springcoredto3app.repo;

import com.xworkz.springcoredto3app.entity.SchoolEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class SchoolRepoImpl implements SchoolRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(SchoolEntity schoolEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(schoolEntity);
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
    public SchoolEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(SchoolEntity.class, id);

    }

    @Override
    public void getByName(String school_name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getByName");
        query.setParameter("name", school_name);
        try {
            SchoolEntity schoolEntity = (SchoolEntity) query.getSingleResult();
            System.out.println(schoolEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public SchoolEntity updateLocationByName(String location, String school_name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateLocationByName");
            query.setParameter("name", school_name);
            query.setParameter("location", location);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query updatedQuery = entityManager.createNamedQuery("getByName");
            updatedQuery.setParameter("name", school_name);
            SchoolEntity schoolEntity = (SchoolEntity) updatedQuery.getSingleResult();
            return schoolEntity;

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
        SchoolEntity schoolEntity = entityManager.find(SchoolEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(schoolEntity);
        entityManager.getTransaction().commit();

    }
}
