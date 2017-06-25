package presentation;


import Models.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class AuthAction extends ActionSupport {
  private User bean;
  private User autheticationUser;

  public String connectUser(){
    
    autheticationUser = bean;
    
    if(autheticationUser == null){
      return "error";
    }

    ServletActionContext.getRequest().getSession().setAttribute("userSession", autheticationUser.getLogin());
    return "success";
  }
  
  @Override
  public void validate(){
    if(bean == null){
        return;
    }
    if(bean.getLogin().trim().length() == 0){
        addFieldError("errorLogin", "Required");
    }
  }

  public User getBean() {
    return bean;
  }

  public void setBean(User bean) {
    this.bean = bean;
  }
}
