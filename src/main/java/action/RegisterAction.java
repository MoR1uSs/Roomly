package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import model.User;

public class RegisterAction extends ActionSupport {
    private String username;
    private String email;
    private String password;

    public String execute() {
        System.out.println("Register action is called");
        UserDao userDAO = new UserDao();

        if(userDAO.getUserByUsername(username) != null) {
            addActionError("Gebruikersnaam bestaat al.");
            return ERROR;
        }

        if(userDAO.getUserByEmail(email) != null) {
            addActionError("E-mailadres bestaat al.");
            return ERROR;
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
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
}

