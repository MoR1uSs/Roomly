package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.WorkspaceDao;
import model.Workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkspacesApiAction extends ActionSupport {
    private List<Workspace> workspaces;

    public String execute() {
        WorkspaceDao workspaceDao = new WorkspaceDao();
        workspaces = workspaceDao.getAllWorkspaces();

        return SUCCESS;
    }

    public List<Workspace> getWorkspaces() {
        if (workspaces == null)
            return Collections.emptyList();

        return workspaces;
    }
}
