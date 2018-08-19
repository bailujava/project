package action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.RegisterService;
import service.RegisterServiceImpl;

import com.opensymphony.xwork2.Action;

import entity.Employee;

public class RegisterAction implements Action{
	private Employee employee;
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		RegisterService RS = new RegisterServiceImpl();
		RS.Register(employee);
		return "success";
	}

}
