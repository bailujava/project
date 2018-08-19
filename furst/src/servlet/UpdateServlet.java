package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateServlet  extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
	
		
				
			PrintWriter out = response.getWriter();
			out.print("<html><body><form action='/furst/xiugai' method='post'>需要修改的账户:<input type='text' name='account'/><br>" +
					"需要修改的密码<input type='text' name='password'/><br>" +
					"<input type='submit' value='确认修改'></form></body></html>");
		
		
	} 
}
