package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.ReservationDao;
import dao.WorkspaceDao;
import model.Reservation;

import java.util.List;
import java.util.Map;

public class ReservationsLoadAction extends ActionSupport {
    List<Reservation> reservations;

    public String execute() {
        ReservationDao reservationDao = new ReservationDao();
        Map<String, Object> session = ActionContext.getContext().getSession();

        reservations = reservationDao.getReservationsByUserId((Long)session.get("userId"));
        return SUCCESS;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getWorkspaceNames(Long workspaceId) {
        WorkspaceDao workspaceDao = new WorkspaceDao();
        return workspaceDao.getById(workspaceId).getName();
    }
}
