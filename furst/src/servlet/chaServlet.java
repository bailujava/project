package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.chaService;
import service.chaServiceIMPL;
import user.User;

public class chaServlet extends  HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		chaService CS = new chaServiceIMPL();
		
		List<User> L = CS.cha();
	
		request.setAttribute("list", L);
		
		request.getRequestDispatcher("/chahou").forward(request, response);
		
		
		
		
	}

}
