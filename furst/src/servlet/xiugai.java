package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UpdateService;
import service.UpdateServiceIMPL;

public class xiugai extends HttpServlet{
public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		

		String account = request.getParameter("account");
		String password = request.getParameter("password");
			 
		UpdateService US = new UpdateServiceIMPL();
		US.update(account, password);
		
			response.sendRedirect("/furst/cha");
		
		
		}

}
