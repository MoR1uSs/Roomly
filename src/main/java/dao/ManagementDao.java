package dao;

import antlr.preprocessor.Hierarchy;
import model.Management;
import org.apache.logging.log4j.core.appender.db.DbAppenderLoggingException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class ManagementDao {
    private DaoManager<Management, Long> daoManager;

    public ManagementDao(){
        daoManager = new DaoManager<>(Management.class);
    }

    public void save(Management management){
        daoManager.save(management);
    }

    public void update(Management management){
        daoManager.update(management);
    }

    public Management findById(Long id){
        return daoManager.findById(id);
    }

    public void deleteById(Long id){
        daoManager.deleteById(id);
    }

    public List<Management> findAll(){
        return daoManager.findAll();
    }
}
