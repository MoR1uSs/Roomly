package dao;

import model.Reservation;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
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
}
