package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import model.User;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    public String execute() {
        UserDao dao = new UserDao();
        User user = dao.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return SUCCESS;
        } else {
            addActionError("Verkeerde gebruikersnaam of wachtwoord.");
            return ERROR;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
