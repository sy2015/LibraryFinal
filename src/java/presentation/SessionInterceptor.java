package presentation;

import Models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;


public class SessionInterceptor implements Interceptor {
  @Override
  public void destroy() {

  }

  @Override
  public void init() { 
  }

  @Override
  public String intercept(ActionInvocation ai) throws Exception {

      User u = (User)ServletActionContext.getRequest().getSession().getAttribute("userSession");
      
      if(u!=null)
      {
        return ai.invoke();
      }
      
      Action action = (Action)ai.getAction();
      if(action instanceof ValidationAware)
      {
          ValidationAware validation = (ValidationAware)action;
          validation.addActionMessage("Autentication Error");
      }
      
      return "fail";
  }
}
