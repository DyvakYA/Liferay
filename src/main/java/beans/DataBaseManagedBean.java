package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import dao.UserDAO;
import entity.User;

@ManagedBean(name = "dataBaseManagedBean")
@SessionScoped
public class DataBaseManagedBean implements CustomManagedBean{
	
	private static Logger logger = Logger.getLogger(DataBaseManagedBean.class);
	
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void execute(ActionEvent event){
		try {
			// Register User
			this.user = UserDAO.getInstance().create(user);
			logger.debug("User Has Registered");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"User has regisered successfully !",""));
			// Reset user
			this.user = new User();
		} catch (Exception e) {
			logger.debug("Registration Process Has Failed",e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Unforunately, user hasn't registered cause to : "+e,""));
		}
	}
}
