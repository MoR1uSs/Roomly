package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.ReservationDao;
import model.Reservation;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class DeleteReservationAction extends ActionSupport {
    private Long id;

    public String execute(){
        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation = reservationDao.getById(id);

        if(id == null){
            System.out.println("id is null");
            return ERROR;
        }

        if(reservation == null){
            return ERROR;
        }

        reservationDao.delete(id);

        return SUCCESS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}