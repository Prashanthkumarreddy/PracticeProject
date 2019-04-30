package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/detail")
public class Details extends  HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		
		
		HttpSession session=req.getSession(false);
		
		if(session!=null) {
			
			out.println("Name:-   Prashanth Kumar Reddy T");
			out.print("DOB:-  27/05/1996");
			
		}else {
			out.println("login is reqiurd");
			
		}
	
	
				
		
		
		
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);

	}
	

	
	
	
}
