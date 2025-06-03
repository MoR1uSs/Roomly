package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.WorkspaceDao;
import model.Workspace;

import java.util.List;

public class WorkspaceSearchAction extends ActionSupport {
    private List<Workspace> workspaces;
    private String term;

    public String execute() {
        WorkspaceDao workspaceDao = new WorkspaceDao();
        workspaces = workspaceDao.searchWorkspacesByName(term);

        return SUCCESS;
    }

    public List<Workspace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<Workspace> workspaces) {
        this.workspaces = workspaces;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
