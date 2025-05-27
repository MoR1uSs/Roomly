import dao.WorkspaceDao;
import model.Workspace;
import model.enums.Status;

import java.util.Stack;

import static model.enums.Status.Bezet;
import static model.enums.Status.Vrij;

public class Main {
    public static void main(String[] args) {
        WorkspaceDao workspaceDao = new WorkspaceDao();

        workspaceDao.deleteById(1L);

        Workspace workspace = new Workspace();
        workspace.setId(1L);
        workspace.setName("A1.09");
        workspace.setCapacity("8");
        workspace.setFacilities("Vergaderruimte");
        workspace.setStatus(Vrij);
        workspace.setLocation("Software development");

        workspaceDao.save(workspace);
    }
}
