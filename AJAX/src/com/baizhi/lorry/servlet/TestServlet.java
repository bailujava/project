package com.baizhi.lorry.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TestServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest requrst, HttpServletResponse response)
		throws ServletException, IOException {
	response.setCharacterEncoding("UTF-8");
	String name = (String) requrst.getParameter("name");
	System.out.println(name);
	PrintWriter out = response.getWriter();
	if("bailu".equals(name)){
	out.write("no");
	}
	else{out.write("right");}
	out.flush();
}
}
