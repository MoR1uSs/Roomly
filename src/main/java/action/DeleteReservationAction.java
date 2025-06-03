package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.ReservationDao;
import model.Reservation;

import java.util.Map;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import static model.enums.Role.DOCENT;

public class DeleteReservationAction extends ActionSupport {
    private Long id;
    Map<String, Object> session;

    public String execute(){
        ReservationDao reservationDao = new ReservationDao();
        Reservation reservation = reservationDao.getById(id);

        session = ActionContext.getContext().getSession();

        if(id == null){
            System.out.println("id is null");
            return ERROR;
        }

        if(reservation == null){
            return ERROR;
        }

        reservationDao.delete(id);

        if(session.get("userRole").equals(DOCENT)){
            return "admin";
        }

        return SUCCESS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}