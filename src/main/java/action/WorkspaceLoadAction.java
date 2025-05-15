package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.WorkspaceDao;
import model.Workspace;

import java.util.List;

public class WorkspaceLoadAction extends ActionSupport {
    private List<Workspace> workspaces;

    public String execute() {
        WorkspaceDao workspacesDao = new WorkspaceDao();
        workspaces = workspacesDao.getAllWorkspaces();

        return SUCCESS;
    }

    public List<Workspace> getWorkspaces(){
        return workspaces;
    }
}
