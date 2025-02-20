package com.xworkz.mobileapp.repo;

import com.xworkz.mobileapp.entity.MobileEntity;
import com.xworkz.mobileapp.repo.MobileRepo;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class MobileRepoImpl implements MobileRepo {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(MobileEntity mobileEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(mobileEntity);
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
    public MobileEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(MobileEntity.class, id);
    }

    @Override
    public void getByName(String mobile_brand) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getByBrand");
        query.setParameter("brand", mobile_brand);
        try {
            MobileEntity mobileEntity=(MobileEntity) query.getSingleResult();
            System.out.println(mobileEntity);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
