package dao;

import antlr.preprocessor.Hierarchy;
import model.Management;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.concurrent.ScheduledExecutorService;

public class ManagementDao {
    public void saveLog(Management log){
        Transaction transaction = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(log);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void getLogById(){
        //TODO
    }
}
