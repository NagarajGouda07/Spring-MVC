package com.xworkz.registeration.repository;

import com.xworkz.registeration.entity.RegisterationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class RegisterationRepoImpl implements RegisterationRepo{

    @Override
    public boolean save(RegisterationEntity registerationEntity) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(registerationEntity);
            entityTransaction.commit();
        }catch (Exception e){
            if (entityTransaction.isActive()){
            entityTransaction.rollback();
            }e.printStackTrace();

        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return false;
    }
}
