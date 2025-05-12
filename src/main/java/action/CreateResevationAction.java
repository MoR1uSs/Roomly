package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;
import dao.ReservationDao;
import dao.WorkspaceDao;
import model.Reservation;
import model.Workspace;

import java.util.Map;

import static com.opensymphony.xwork2.Action.*;

public class CreateResevationAction extends ActionSupport {
    private Long userId;
    private Long selectedWorkspaceId;
    private String date;
    private String time;
    private String description;

    public String execute(){
        if(date == null || time == null){
            return INPUT;
        }

        WorkspaceDao workspaceDao = new WorkspaceDao();
        Workspace ws = workspaceDao.getById(selectedWorkspaceId);

        if(ws == null){
            addActionError("Ongelide locatie");
            return INPUT;
        }

        Map<String, Object> session = ActionContext.getContext().getSession();

        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation = new Reservation();

        Object id = session.get("userId");

        reservation.setUserId((Long) id);
        reservation.setWorkspaceId(selectedWorkspaceId);
        reservation.setDate(date);
        reservation.setTime(time);

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
