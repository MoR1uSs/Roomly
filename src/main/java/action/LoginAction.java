package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import model.User;

public class LoginAction extends ActionSupport {
    private String email;
    private String password;

    public String execute() {
        UserDao dao = new UserDao();
        User user = dao.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return SUCCESS;
        } else {
            addActionError("Verkeerde gebruikersnaam of wachtwoord.");
            return ERROR;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
