package action;

import dao.WorkspacesDao;
import model.Workspace;

import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class WorkspaceAction {
    private List<Workspace> workspaces;

    public String execute() {
        WorkspacesDao workspacesDao = new WorkspacesDao();
        workspaces = workspacesDao.getAllWorkspaces();
        return SUCCESS;
    }

    public List<Workspace> getWorkspaces(){
        return workspaces;
    }
}
