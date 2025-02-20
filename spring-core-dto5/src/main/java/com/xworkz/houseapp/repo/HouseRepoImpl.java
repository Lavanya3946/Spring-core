package com.xworkz.houseapp.repo;

import com.xworkz.houseapp.entity.HouseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class HouseRepoImpl implements HouseRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(HouseEntity houseEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(houseEntity);
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
    public HouseEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(HouseEntity.class, id);
    }

    @Override
    public Void getByName(String house_name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getDataByName");
        query.setParameter("name", house_name);
        try {
            HouseEntity singleResult = (HouseEntity) query.getSingleResult();
            System.out.println(singleResult);

        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public HouseEntity updateHouseNoByName(String house_name, Integer houseNo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateHouseNoByName");
            query.setParameter("name", house_name);
            query.setParameter("houseNo", houseNo);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query updatedQuery = entityManager.createNamedQuery("getDataByName");
            updatedQuery.setParameter("name", house_name);
            HouseEntity houseEntity = (HouseEntity) updatedQuery.getSingleResult();
            return houseEntity;


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
        HouseEntity stateEntity = entityManager.find(HouseEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(stateEntity);
        entityManager.getTransaction().commit();


    }
}
