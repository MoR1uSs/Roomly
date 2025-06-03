package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

import static model.enums.Role.DOCENT;

public class AdminInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();

        Object userRole = session.get("userRole");

        if(userRole != DOCENT){
            return "login";
        }

        return actionInvocation.invoke();
    }
}
