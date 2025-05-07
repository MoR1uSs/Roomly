package action;

import com.sun.net.httpserver.Authenticator;
import dao.ReservationDao;
import model.Reservation;

import static com.opensymphony.xwork2.Action.*;

public class CreateResevationAction {
    private int userId;
    private int workspaceId;
    private String date;
    private String time;
    private String description;

    public String execute(){
        if(date == null || time == null){
            return INPUT;
        }

        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation = new Reservation();

        reservation.setUserId(userId);
        reservation.setWorkspaceId(workspaceId);
        reservation.setDate(date);
        reservation.setTime(time);

        if(description != null){
            reservation.setDescription(description);
        }

        reservationDao.saveReservation(reservation);
        return SUCCESS;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(int workspaceId) {
        this.workspaceId = workspaceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
