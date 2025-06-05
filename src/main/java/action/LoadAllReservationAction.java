package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.ReservationDao;
import dao.UserDao;
import dao.WorkspaceDao;
import model.Reservation;
import model.User;
import org.apache.struts2.interceptor.SessionAware;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static model.enums.Role.DOCENT;

public class LoadAllReservationAction extends ActionSupport implements SessionAware {
    private List<Reservation> reservations;
    private Map<String, Object> session;

    public String execute(){
        ReservationDao reservationDao = new ReservationDao();
        reservations = reservationDao.findAll();

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

    public String getUsername(Long reservationId) {
        ReservationDao reservationDao = new ReservationDao();
        UserDao userDao = new UserDao();

        Reservation reservation = reservationDao.getById(reservationId);

        User user = userDao.getUserById(reservation.getUserId());

        return user.getName() + " " + user.getSurname();
    }

    public boolean getCheckRole() {
        Object role = session.get("userRole");
        return DOCENT.equals(role);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
