package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.WorkspaceDao;
import model.Workspace;
import org.apache.struts2.interceptor.SessionAware;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static model.enums.Role.DOCENT;

public class WorkspaceLoadAction extends ActionSupport implements SessionAware {
    private List<Workspace> workspaces;
    private Map<String, Object> session;
    private Long selectedWorkspaceId;

    public String execute() {
        WorkspaceDao workspacesDao = new WorkspaceDao();
        workspaces = workspacesDao.getAllWorkspaces();
        return SUCCESS;
    }

    public List<Workspace> getWorkspaces(){
        return workspaces;
    }

    public void setWorkspaces(List<Workspace> workspaces) {
        this.workspaces = workspaces;
    }

    public boolean getCheckRole() {
        Object role = session.get("userRole");
        return DOCENT.equals(role);
    }

    public Long getSelectedWorkspaceId() {
        return selectedWorkspaceId;
    }

    public void setSelectedWorkspaceId(Long selectedWorkspaceId) {
        this.selectedWorkspaceId = selectedWorkspaceId;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
