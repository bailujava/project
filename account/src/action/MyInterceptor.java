package action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		try {
			Map<String, Object> session = ServletActionContext.getContext().getSession();
			String S = (String)session.get("denglu");
			System.out.println(S);
			if(S!=null){arg0.invoke();}
			return null;
		} catch (Exception e) {	
			return "error";}
		
		
	}

}
