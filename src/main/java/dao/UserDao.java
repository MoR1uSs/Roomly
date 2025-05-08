package dao;

import com.sun.xml.bind.v2.model.core.ID;
import model.Management;
import model.enums.Role;
import org.apache.logging.log4j.core.appender.db.DbAppenderLoggingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import model.User;

import java.util.List;

public class UserDao {
    private DaoManager<User, Long> daoManager;

    public UserDao(){
        daoManager = new DaoManager<>(User.class);
    }

    public void save(User user){
        daoManager.save(user);
    }

    public User getUserById(Long id){
        return daoManager.findById(id);
    }

    public void update(User user){
        daoManager.update(user);
    }

    public void deleteById(Long id){
        daoManager.deleteById(id);
    }

    public List<User> getAllUsers() {
        return daoManager.findAll();
    }

    public User getUserByEmail(String email){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Query<User> query = session.createQuery("FROM User WHERE email = :email", model.User.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public User getUserByUsername(String username) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query<User> query = session.createQuery("FROM User WHERE username = :username", model.User.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Role determineRole(String email){
         if(email != null && email.toLowerCase().contains("student")) {
             return Role.STUDENT;
         } else {
             return Role.DOCENT;
         }
    }

    public boolean isDocent(User user){
        return user.getRole() == Role.DOCENT;
    }

    public boolean isStudent(User user){
        return user.getRole() == Role.STUDENT;
    }
}
