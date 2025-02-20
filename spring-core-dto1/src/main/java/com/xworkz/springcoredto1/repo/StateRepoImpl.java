package com.xworkz.springcoredto1.repo;

import com.xworkz.springcoredto1.entity.StateEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class StateRepoImpl implements StateRepo {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(StateEntity stateEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(stateEntity);
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
    public StateEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(StateEntity.class, id);

    }

    @Override
    public Void getByName(String state_name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getDataByName");
        query.setParameter("name", state_name);
        try {
            StateEntity singleResult = (StateEntity) query.getSingleResult();
            System.out.println(singleResult);

        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public StateEntity updateStateNameByNOfPopulation(String state_name, Integer no_OfPeople) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateNoOfPeopleByName");
            query.setParameter("name", state_name);
            query.setParameter("noOfPeople", no_OfPeople);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query updatedQuery = entityManager.createNamedQuery("getDataByName");
            updatedQuery.setParameter("name", state_name);
            StateEntity stateEntity = (StateEntity) updatedQuery.getSingleResult();
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
        StateEntity stateEntity = entityManager.find(StateEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(stateEntity);
        entityManager.getTransaction().commit();


    }
}


