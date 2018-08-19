package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.chaService;
import service.chaServiceIMPL;
import user.User;

public class chaAfter extends  HttpServlet{
	
		
		public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			
			
			List<User> L = (List<User>)request.getAttribute("list");
			PrintWriter writer = response.getWriter();
			writer.print("<html> <head> <meta http-equiv='Content-Type' content='text/html; charset=GBK' /> </head>");
			writer.print("<body><table><tr><td>ID</td><td>用户名</td><td>密码</td></tr>");
			for (User user : L) {
			writer.print("<tr><td>"+user.getId()+"</td><td>"+user.getAccount()+"</td><td>"+user.getPassword()+"</td></tr>");
			}
			writer.print("</table><a href='/furst/UpdateServlet'>修改</a> </body></html>");
			writer.flush();
	}

}
