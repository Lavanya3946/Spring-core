package com.xworkz.springcoredto2app.repo;

import com.xworkz.springcoredto2app.entity.DistrictEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class DistrictRepoImpl implements DistrictRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(DistrictEntity districtEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(districtEntity);
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
    public DistrictEntity getById(Integer id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        return  entityManager.find(DistrictEntity.class,id);

    }

    @Override
    public void getByName(String district_name) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        Query query=entityManager.createNamedQuery("getByName");
        query.setParameter("name",district_name);
        try{
            DistrictEntity districtEntity=(DistrictEntity) query.getSingleResult();
            System.out.println(districtEntity);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public DistrictEntity updateTaluksByName(String district_name, Integer no_Of_Taluks) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
          Query query=  entityManager.createNamedQuery("updateDataOfTaluksByName");
          query.setParameter("name",district_name);
          query.setParameter("noOfTaluks",no_Of_Taluks);
          query.executeUpdate();
          entityManager.getTransaction().commit();

          Query updatedquery=entityManager.createNamedQuery("getByName");
          updatedquery.setParameter("name",district_name);
          DistrictEntity districtEntity=(DistrictEntity) query.getSingleResult();
          return  districtEntity;

        }catch (Exception e){
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            return  null;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    @Override
    public void removeById(Integer id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
       DistrictEntity districtEntity= entityManager.find(DistrictEntity.class,id);
       entityManager.getTransaction().begin();
       entityManager.remove(districtEntity);
       entityManager.getTransaction().commit();

    }
}
