package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FristServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h1>"+new Date()+"</h1>");
		out.println("<h2> this is dynamic page </h2>");
		Employee emp= new Employee(1224, "sakbc", 645468);
		req.setAttribute("emps", emp);
		
		
		//ServletConfig config=  getServletConfig();
		//ServletContext contxt=config.getServletContext();
		RequestDispatcher dis=  req.getRequestDispatcher("ht.html");
		dis.forward(req, resp);
//		out.println(contxt.getInitParameter("email"));
//		
	}

}
