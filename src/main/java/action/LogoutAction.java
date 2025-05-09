package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.AbstractCollection;

public class LogoutAction extends ActionSupport {
    public String execute(){
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }
}
