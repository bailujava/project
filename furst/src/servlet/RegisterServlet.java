package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RegisterService;
import service.RegisterServiceIMPL;
import user.User;

public class RegisterServlet extends HttpServlet  {
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		    
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		User u =new User(account,password);
		RegisterService RS=new RegisterServiceIMPL();
		boolean flag=RS.register(u);
		
		
			response.sendRedirect("/furst/login.html");	
		
	
		
	}

}
