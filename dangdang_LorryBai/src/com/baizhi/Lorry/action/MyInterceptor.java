package com.baizhi.Lorry.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.baizhi.Lorry.entity.D_user;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

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
			ValueStack vs = ActionContext.getContext().getValueStack();
			D_user user = (D_user) vs.findValue("#session.user");
			System.out.println(user);
			if(user!=null){ 
				arg0.invoke();
				return null;}
			else{return "error";}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}

}
