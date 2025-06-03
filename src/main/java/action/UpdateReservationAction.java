package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.ReservationDao;
import model.Reservation;

import java.time.LocalTime;

public class UpdateReservationAction extends ActionSupport {
    private Long id;
    private String newBeginTime;
    private String newEndTime;

    public String execute() {
        ReservationDao reservationDao = new ReservationDao();

        LocalTime parsedBeginTime = LocalTime.parse(newBeginTime);
        LocalTime parsedEndTime = LocalTime.parse(newEndTime);

        reservationDao.updateTime(id, parsedBeginTime, parsedEndTime);

        return SUCCESS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewBeginTime() {
        return newBeginTime;
    }

    public void setNewBeginTime(String newBeginTime) {
        this.newBeginTime = newBeginTime;
    }

    public String getNewEndTime() {
        return newEndTime;
    }

    public void setNewEndTime(String newEndTime) {
        this.newEndTime = newEndTime;
    }
}
