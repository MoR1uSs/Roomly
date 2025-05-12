package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import model.User;
import model.enums.Role;

public class RegisterAction extends ActionSupport {
    private String name;
    private String surname;
    private String email;
    private String password;

    public String execute() {
        UserDao userDAO = new UserDao();

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
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        userDAO.save(user);
        return SUCCESS;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

