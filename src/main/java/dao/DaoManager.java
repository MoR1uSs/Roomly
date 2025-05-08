package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.beanvalidation.HibernateTraversableResolver;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public class DaoManager<T, Long> {

    private final Class<T> entityClass;

    public DaoManager(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public T findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(entityClass, (Serializable) id);
        } catch (HibernateException e) {
            throw new RuntimeException("Failed to find entity by ID", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void save(T object) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save entity", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(T object) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to update entity", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteById(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            T entity = session.get(entityClass, (Serializable) id);
            if (entity != null) {
                session.delete(entity);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to delete entity", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<T> findAll(){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM " + entityClass.getSimpleName();
            return session.createQuery(hql, entityClass).list();
        } catch (Exception e){
            throw new RuntimeException("Failed to find all entities", e);
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
