package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import service.CalculationService;
import service.Service;

@ManagedBean(name = "calculationManagedBean")
@SessionScoped
public class CalculationManagedBean {

	private static Logger logger = Logger.getLogger(CalculationManagedBean.class);

	Service service = new CalculationService();

	private String value1;

	private String value2;

	private String operation;

	int result;

	public void execute(ActionEvent event) {
		try {
			// Do operation
			this.result = service.calc(Integer.valueOf(value1), Integer.valueOf(value2), operation);
			logger.debug("Operetion making");

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Result = " + result, ""));

		} catch (Exception e) {
			logger.debug("Operation Has Failed", e);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Unforunately! Operation has failed cause to : " + e, ""));
		}
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
