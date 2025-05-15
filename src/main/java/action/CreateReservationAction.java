package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.ReservationDao;
import model.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class CreateReservationAction extends ActionSupport {
    private Long userId;
    private Long selectedWorkspaceId;
    private String date;
    private String beginTime;
    private String endTime;
    private String description;

    public String execute(){
        if(date == null || beginTime == null || endTime == null){
            return INPUT;
        }

        LocalDate parsedDate;
        LocalTime parsedBeginTime;
        LocalTime parsedEndTime;

        try{
            parsedDate = LocalDate.parse(date);
            parsedBeginTime = LocalTime.parse(beginTime);
            parsedEndTime = LocalTime.parse(endTime);
        } catch (Exception e){
            addActionError("Ongeldig datum of tijd formaat.");
            return INPUT;
        }

        if(!parsedBeginTime.isBefore(parsedEndTime)){
            addActionError("Ongeldig tijd");
            return INPUT;
        }

        Map<String, Object> session = ActionContext.getContext().getSession();

        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation = new Reservation();

        Object id = session.get("userId");

        reservation.setUserId((Long) id);
        reservation.setWorkspaceId(selectedWorkspaceId);
        reservation.setDate(parsedDate);
        reservation.setBeginTime(parsedBeginTime);
        reservation.setEndTime(parsedEndTime);

        List<Reservation> reservationList = reservationDao.findAll();

        for (Reservation res : reservationList) {
            if (res.getWorkspaceId().equals(selectedWorkspaceId) && res.getDate().isEqual(parsedDate)) {
                if (!(parsedEndTime.isBefore(res.getBeginTime()) || parsedBeginTime.isAfter(res.getEndTime()))) {
                    addActionError("De werkruimte is al gereserveerd voor de geselecteerde tijd.");
                    return INPUT;
                }
            }
        }

        if(description != null){
            reservation.setDescription(description);
        }

        reservationDao.save(reservation);
        return SUCCESS;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSelectedWorkspaceId() {
        return selectedWorkspaceId;
    }

    public void setSelectedWorkspaceId(Long selectedWorkspaceId) {
        this.selectedWorkspaceId = selectedWorkspaceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
