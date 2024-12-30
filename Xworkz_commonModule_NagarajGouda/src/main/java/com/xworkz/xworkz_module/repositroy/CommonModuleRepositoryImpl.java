package com.xworkz.xworkz_module.repositroy;

import com.xworkz.xworkz_module.entity.CommonModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CommonModuleRepositoryImpl implements CommonModuleRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public CommonModuleRepositoryImpl()
    {
        System.out.println("created CommonModuleRepositoryImpl");
    }
    @Override
    public boolean save(CommonModuleEntity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public Long getCountOfName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getCountOfName");
        query.setParameter("setName", name);
        Long count = (Long) query.getSingleResult();
        entityManager.close();
        return count;
    }

    @Override
    public Long getCountOfEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getCountOfEmail");
        query.setParameter("setEmail", email);
        Long count = (Long) query.getSingleResult();
        entityManager.close();
        return count;
    }

    @Override
    public Long getCountOfPhone(String phone) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getCountOfPhone");
        query.setParameter("setPh", phone);
        Long count = (Long) query.getSingleResult();
        entityManager.close();
        return count;
    }

    @Override
    public Long getCountOfAlterEmail(String alterEmail) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getCountOfAlterEmail");
        query.setParameter("setAlterEmail", alterEmail);
        Long count = (Long) query.getSingleResult();
        entityManager.close();
        return count;
    }

    @Override
    public Long getCountOfAlterPhone(String alterPhone) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getCountOfAlterPhone");
        query.setParameter("setAlterPhone", alterPhone);
        Long count = (Long) query.getSingleResult();
        entityManager.close();
        return count;
    }

    @Override
    public CommonModuleEntity onSignin(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       EntityTransaction et=entityManager.getTransaction();
       CommonModuleEntity CommonModuleEntity=null;
        List<CommonModuleEntity> resultList = entityManager.createNamedQuery("getValue", CommonModuleEntity.class).setParameter("email", email).getResultList();

        if (!resultList.isEmpty()) {
            CommonModuleEntity = resultList.get(0);
        }

        try {
            et.begin();
           et.commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();
        }
        System.out.println("from : "+CommonModuleEntity);
        return CommonModuleEntity;
    }

    @Override
    public CommonModuleEntity getData(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("getValue");
            query.setParameter("email", email);
            return (CommonModuleEntity) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean onUpdate(CommonModuleEntity commonModuleEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(commonModuleEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public int getCount(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();
            Object object=entityManager.createNamedQuery("getCountValue").setParameter("email",email).getSingleResult();
            Integer integer=(Integer)object;
            transaction.commit();
            return integer;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("null");
            return 0;
        } finally {
            entityManager.close();
        }


    }

    @Override
    public boolean updateCount(int i ,String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();
            int value=  entityManager.createNamedQuery("updateCount").setParameter("setEmail",email).setParameter("setNo",i).executeUpdate();
            System.out.println(value);
            transaction.commit();

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            entityManager.close();
        }
        return true;
    }
}
