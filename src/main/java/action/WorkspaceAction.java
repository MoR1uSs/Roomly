package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.WorkspaceDao;
import model.Workspace;

import java.util.List;
import java.util.Map;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class WorkspaceAction extends ActionSupport {
    private List<Workspace> workspaces;

    public String execute() {
        WorkspaceDao workspacesDao = new WorkspaceDao();
        workspaces = workspacesDao.getAllWorkspaces();
        Map<String, Object> session = ActionContext.getContext().getSession();
        String user = (String) session.get("user");

        if(user == null) return LOGIN;

        return SUCCESS;
    }

    public List<Workspace> getWorkspaces(){
        return workspaces;
    }
}
