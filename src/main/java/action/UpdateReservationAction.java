package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.ReservationDao;
import model.Reservation;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class UpdateReservationAction extends ActionSupport {
    private Long id;
    private String newBeginTime;
    private String newEndTime;

    public String execute() {
        ReservationDao reservationDao = new ReservationDao();

        List<Reservation> matchingReservations;

        LocalTime parsedBeginTime = LocalTime.parse(newBeginTime);
        LocalTime parsedEndTime = LocalTime.parse(newEndTime);

        Reservation thisReservation = reservationDao.getById(id);
        Long workspaceId = thisReservation.getWorkspaceId();

        matchingReservations = reservationDao.findAll().stream()
                        .filter(reservation -> Objects.equals(reservation.getWorkspaceId(), workspaceId) && reservation.getDate().equals(thisReservation.getDate()))
                                .findAny().stream().toList();

        for(Reservation reservation : matchingReservations){
            if(reservation.getId().equals(id)){
                continue;
            }

            boolean isOverlapping = !(parsedEndTime.isBefore(reservation.getBeginTime()) ||
                    parsedBeginTime.isAfter(reservation.getEndTime()));

            if (isOverlapping){
                addActionError("wong time");
                return INPUT;
            }
        }

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
