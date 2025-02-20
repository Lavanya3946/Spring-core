package com.xworkz.mallapp.repo;

import com.xworkz.mallapp.entity.MallEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.namespace.QName;


@Component
public class MallRepoImpl implements MallRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");

    @Override
    public boolean save(MallEntity mallEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(mallEntity);
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
    public MallEntity getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(MallEntity.class, id);
    }

    @Override
    public void getByName(String mall_name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getByName");
        query.setParameter("name", mall_name);
        try {
            MallEntity mallEntity = (MallEntity) query.getSingleResult();
            System.out.println(mallEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public MallEntity updateLocationByName(String location, String mall_name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("updateLocationByName");
            query.setParameter("location", location);
            query.setParameter("name", mall_name);
            query.executeUpdate();
            entityManager.getTransaction().commit();

            Query updatequery = entityManager.createNamedQuery("getByName");
            MallEntity mallEntity = (MallEntity) updatequery.getSingleResult();
            return mallEntity;
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
    public MallEntity removeById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MallEntity mallEntity = entityManager.find(MallEntity.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(mallEntity);
        entityManager.getTransaction().commit();
        return null;
    }
}
