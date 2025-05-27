package dao;

import model.Reservation;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReservationDao {
    private DaoManager<Reservation, Long> daoManager;

    public ReservationDao(){
        daoManager = new DaoManager<>(Reservation.class);
    }

    public void save(Reservation reservation) {
        daoManager.save(reservation);
    }

    public Reservation getById(Long id){
        return daoManager.findById(id);
    }

    public void update(Reservation reservation){
        daoManager.update(reservation);
    }

    public void delete(Long id){
        daoManager.deleteById(id);
    }

    public List<Reservation> findAll(){
        return daoManager.findAll();
    }

    public List<Reservation> getReservationsByWorkspaceId(Long id){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Query<Reservation> query = session.createQuery("FROM Reservation WHERE workspaceId = :id", model.Reservation.class);
            query.setParameter("id", id);
            return query.list();
        } catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public List<Reservation> getReservationsByUserId(Long id){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query<Reservation> query = session.createQuery("FROM Reservation WHERE userId = :id", model.Reservation.class);
            query.setParameter("id", id);
            return query.list();
        } catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
