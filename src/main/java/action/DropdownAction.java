package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.WorkspaceDao;
import model.Workspace;

import java.util.ArrayList;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class DropdownAction extends ActionSupport {
    private List<Workspace> workspaces;
    private Long selectedWorkspaceId;

    public String execute() {
        WorkspaceDao workspacesDao = new WorkspaceDao();
        workspaces = workspacesDao.getAllWorkspaces();
        return SUCCESS;
    }

    public List<Workspace> getWorkspaces(){
        System.out.println("Returning workspaces: " + (workspaces == null ? "null" : workspaces.size()));
        return workspaces;
    }

    public void setWorkspaces(List<Workspace> workspaces) {
        this.workspaces = workspaces;
    }

    public Long getSelectedWorkspaceId() {
        return selectedWorkspaceId;
    }

    public void setSelectedWorkspaceId(Long selectedWorkspaceId) {
        this.selectedWorkspaceId = selectedWorkspaceId;
    }
}