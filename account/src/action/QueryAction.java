package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.ShowService;
import service.ShowServiceImpl;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import entity.Employee;

public class QueryAction implements Action{
	private List<Employee> list;
	public List<Employee> getList() {
		return list;
	}
	public void setList(List<Employee> list) {
		this.list = list;
	}
	public String execute() throws Exception {
			
			HttpServletRequest request = ServletActionContext.getRequest();
			ShowService SS = new ShowServiceImpl();
			list = SS.Query();
			for (Employee ss : list) {
				System.out.println(ss);
			}
			System.out.println();
			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.setValue("#request.l", list);

			return "success";
		}

	

}
