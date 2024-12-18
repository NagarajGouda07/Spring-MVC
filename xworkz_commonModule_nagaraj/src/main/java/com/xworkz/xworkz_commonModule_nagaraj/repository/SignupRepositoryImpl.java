package com.xworkz.xworkz_commonModule_nagaraj.repository;

import com.xworkz.xworkz_commonModule_nagaraj.entity.SignupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class SignupRepositoryImpl implements SignupRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public SignupRepositoryImpl() {
        System.out.println("No-Args Const of SignupRepositoryImpl");
    }

    @Override
    public boolean send(SignupEntity entity) {

        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            manager.close();
        }
        return true;
    }
}
