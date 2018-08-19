package action;

import service.LoginService;
import service.LoginServiceImpl;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class LoginAction implements Action{
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception {
			try {
				LoginService IS = new LoginServiceImpl();
				IS.Login(id);
				ValueStack vs = ActionContext.getContext().getValueStack();
				vs.setValue("#session.denglu", "loginsuccess");
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
	}

}
