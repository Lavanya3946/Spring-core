package com.xworkz.Pgapp.repo;

import com.xworkz.Pgapp.entity.PgEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class PgRepoImpl implements PgRepo {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(PgEntity pgEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pgEntity);
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
    public PgEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(PgEntity.class, id);
    }

    @Override
    public Void getByName(String pg_name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getDataByName");
        query.setParameter("pgName", pg_name);
        try {
            PgEntity singleResult = (PgEntity) query.getSingleResult();
            System.out.println(singleResult);

        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public PgEntity updateCostByName(String pg_name, Integer cost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateCostByName");
            query.setParameter("pgName", pg_name);
            query.setParameter("cost", cost);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query updatedQuery = entityManager.createNamedQuery("getDataByName");
            updatedQuery.setParameter("pg_name", pg_name);
            PgEntity stateEntity = (PgEntity) updatedQuery.getSingleResult();
            return stateEntity;


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
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PgEntity stateEntity = entityManager.find(PgEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(stateEntity);
        entityManager.getTransaction().commit();

    }
}
