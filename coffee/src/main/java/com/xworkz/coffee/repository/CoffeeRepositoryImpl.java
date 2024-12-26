package com.xworkz.coffee.repository;

import com.xworkz.coffee.entity.CoffeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class CoffeeRepositoryImpl implements CoffeeRepository{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public CoffeeRepositoryImpl(){
        System.out.println("This is a CoffeeRepositoryImpl const.......");
    }

    @Override
    public boolean saveRepo(CoffeeEntity coffeeEntity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(coffeeEntity);
        transaction.commit();
        return true;
    }
}
