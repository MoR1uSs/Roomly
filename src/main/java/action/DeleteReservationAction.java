package action;

import dao.ReservationDao;
import model.Reservation;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class DeleteReservationAction {
    private ReservationDao reservationDao;
    private Long reservationId;
    private Long userId;

    public String execute(){
        Reservation reservation = reservationDao.getById(reservationId);

        if(reservation == null){
            return ERROR;
        }

        reservationDao.delete(reservationId);

        return SUCCESS;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}