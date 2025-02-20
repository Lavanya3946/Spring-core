package com.xworkz.carapp.repo;

import com.xworkz.carapp.entity.CarEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


@Component
public class CarRepoImpl implements CarRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(CarEntity carEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(carEntity);
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
    public CarEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(CarEntity.class, id);
    }

    @Override
    public void getByBrand(String car_brand) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getByBrand");
        query.setParameter("brand", car_brand);
        try {
            CarEntity car = (CarEntity) query.getSingleResult();
            System.out.println(car);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public CarEntity updateCostByBrand(Double cost, String car_brand) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateCostByBrand");
            query.setParameter("cost", cost);
            query.setParameter("brand", car_brand);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query updatedQuery = entityManager.createNamedQuery("getByBrand");
            updatedQuery.setParameter("brand", car_brand);

            CarEntity car = (CarEntity) updatedQuery.getSingleResult();
            return car;
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
    public CarEntity removeById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CarEntity carEntity = entityManager.find(CarEntity.class, id);
        entityManager.remove(carEntity);
        entityManager.getTransaction().begin();
        entityManager.remove(carEntity);
        entityManager.getTransaction().commit();
        return null;
    }
}
