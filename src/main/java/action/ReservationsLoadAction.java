package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.ReservationDao;
import dao.WorkspaceDao;
import model.Reservation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ReservationsLoadAction extends ActionSupport {
    private List<Reservation> reservations;

    public String execute() {
        ReservationDao reservationDao = new ReservationDao();
        Map<String, Object> session = ActionContext.getContext().getSession();

        System.out.println((Long)session.get("userId"));
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

    public String parseDate(Long reservationId) {
        ReservationDao reservationDao = new ReservationDao();
        LocalDate date = reservationDao.getById(reservationId).getDate();

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        String formattedDate = date.format(outputFormatter);

        return formattedDate;
    }
}
