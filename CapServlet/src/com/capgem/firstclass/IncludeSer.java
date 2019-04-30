package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/include")

public class IncludeSer extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.print("include method class ");
		RequestDispatcher dis=req.getRequestDispatcher("/date");
		dis.include(req, resp);
		
		Employee emp=(Employee)req.getAttribute("emps");	
		System.out.println(emp);
		
		
		
	}

}
