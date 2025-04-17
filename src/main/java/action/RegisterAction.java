package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import model.User;
import model.enums.Role;

public class RegisterAction extends ActionSupport {
    private String username;
    private String email;
    private String password;

    public String execute() {
        UserDao userDAO = new UserDao();

        if(userDAO.getUserByUsername(username) != null) {
            addActionError("Gebruikersnaam bestaat al.");
            return ERROR;
        }

        if(!email.toLowerCase().endsWith("scalda.nl")){
            addActionError("E-mailadres moet eindigen op @scalda.nl");
            return ERROR;
        }

        if(userDAO.getUserByEmail(email) != null) {
            addActionError("E-mailadres bestaat al.");
            return ERROR;
        }

        User user = new User();
        Role role = userDAO.determineRole(email);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        userDAO.saveUser(user);
        return SUCCESS;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

