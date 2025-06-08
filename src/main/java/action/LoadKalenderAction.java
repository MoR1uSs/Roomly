package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.ReservationDao;
import model.Reservation;

import java.util.List;
import java.util.Map;

import static model.enums.Role.DOCENT;

public class LoadKalenderAction extends ActionSupport {
    public Map<String, Object> session = ActionContext.getContext().getSession();

    public String execute(){
        ReservationDao reservationDao = new ReservationDao();
        List<Reservation> reservationList = reservationDao.findAll();

        return SUCCESS;
    }

    public boolean getCheckRole() {
        Object role = session.get("userRole");
        return DOCENT.equals(role);
    }
}