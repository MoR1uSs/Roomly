package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import model.User;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
    private String email;
    private String password;
    private Map<String, Object> session;

    public String doLogin() {
        if (email == null || password == null) {
            return INPUT;
        }
        UserDao dao = new UserDao();
        User user = dao.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            session.put("userId", user.getId());
            session.put("userEmail", email);
            session.put("userRole", user.getRole());
            return SUCCESS;
        } else {
            addActionError("Verkeerde gebruikersnaam of wachtwoord.");
            return ERROR;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
