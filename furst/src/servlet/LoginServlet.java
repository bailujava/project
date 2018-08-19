package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceIMPL;
import user.User;

public class LoginServlet extends  HttpServlet{

		public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServerException{
		
			HttpSession session = request.getSession();
			String code = request.getParameter("code");
			String C= (String)session.getAttribute("validationCode");
			
			if(C.equals(code)){
			String account=request.getParameter("account");
			String password=request.getParameter("password");
			LoginService  loginService = new LoginServiceIMPL();
			 User u=new User(account,password);
			 boolean flag=loginService.login(u);
			 
			 
			 if(flag){
				 	
				 	session.setAttribute("denglu", "µÇÂ½³É¹¦");
				 response.sendRedirect("/furst/cha");
			          }
			 else{ 
				response.sendRedirect("/furst/login.html");
			 }
		                        }
			else{response.sendRedirect("/furst/login.html");}
		}
}
