package com.xworkz.xworkz_course_reg.repository;

import com.xworkz.xworkz_course_reg.entity.XworkzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class XworkzRepositoryImpl implements XworkzRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public XworkzRepositoryImpl() {
        System.out.println("No-Args Constructor of XworkzRepositoryImpl");
    }

    @Override
    public boolean save(XworkzEntity xworkzEntity) {
        System.out.println("Executing save in RepositoryImpl");
        System.out.println("REPO: " + xworkzEntity);

        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(xworkzEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public XworkzEntity findByEmail(String email) {
        System.out.println("Executing findByEmail in RepositoryImpl");
        XworkzEntity xworkzEntity = null;

        try {
            Query query = entityManager.createNamedQuery("getByEmail");
            query.setParameter("byemail", email);
            xworkzEntity = (XworkzEntity) query.getSingleResult();
            System.out.println("REPO: " + xworkzEntity);
        } catch (NoResultException e) {
            System.out.println("No result found for email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xworkzEntity;
    }
}
