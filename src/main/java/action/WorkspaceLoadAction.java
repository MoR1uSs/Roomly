package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.ReservationDao;
import dao.WorkspaceDao;
import model.Reservation;
import model.Workspace;
import model.enums.Status;
import org.apache.struts2.interceptor.SessionAware;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static model.enums.Role.DOCENT;

public class WorkspaceLoadAction extends ActionSupport implements SessionAware {
        private List<Workspace> workspaces;
        private List<Reservation> reservations;
        private Map<String, Object> session;
        private Long selectedWorkspaceId;

        public String execute() {
            WorkspaceDao workspacesDao = new WorkspaceDao();
            workspaces = workspacesDao.getAllWorkspaces();

            workspaces.forEach(workspace -> determineStatus(workspace.getId()));

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

        public List<Workspace> getWorkspaces(){
            return workspaces;
        }

        public void setWorkspaces(List<Workspace> workspaces) {
            this.workspaces = workspaces;
        }

        public void determineStatus(Long workspaceId){
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();

            WorkspaceDao workspaceDao = new WorkspaceDao();
            ReservationDao reservationDao = new ReservationDao();

            Workspace thisWorkspace = workspaceDao.getById(workspaceId);

            if(thisWorkspace == null){
                throw new RuntimeException("Workspace doesnt exist");
            }

            List<Reservation> activeReservations = reservationDao.findActiveReservations(workspaceId, localDate, localTime);

            if(activeReservations.isEmpty()){
                thisWorkspace.setStatus(Status.Vrij);
            } else {
                thisWorkspace.setStatus(Status.Bezet);
            }

            workspaceDao.update(thisWorkspace);
        }

        public boolean getCheckRole() {
            Object role = session.get("userRole");
            return DOCENT.equals(role);
        }

        public Long getSelectedWorkspaceId() {
            return selectedWorkspaceId;
        }

        public String getWorkspaceNames(Long reservationId) {
            ReservationDao reservationDao = new ReservationDao();
            Reservation reservation = reservationDao.getById(reservationId);

            WorkspaceDao workspaceDao = new WorkspaceDao();
            return workspaceDao.getById(reservation.getWorkspaceId()).getName();
        }

        public String parseDate(Long reservationId) {
            ReservationDao reservationDao = new ReservationDao();
            LocalDate date = reservationDao.getById(reservationId).getDate();

            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
            String formattedDate = date.format(outputFormatter);

            return formattedDate;
        }

        public void setSelectedWorkspaceId(Long selectedWorkspaceId) {
            this.selectedWorkspaceId = selectedWorkspaceId;
        }
        @Override
        public void setSession(Map<String, Object> session) {
            this.session = session;
        }
}
