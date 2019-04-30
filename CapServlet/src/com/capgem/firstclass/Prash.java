package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/prash")
public class Prash extends HttpServlet   {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   PrintWriter out= resp.getWriter();
	   resp.setContentType("html/text");
		String name=req.getParameter("id");
		String pass=req.getParameter("password");

		
		try {
			String nam="prashanth";
			String pas="prashanth";
			
			if(nam.equals(name)&&pas.equals(pass)) {
			HttpSession session =req.getSession();
			
			resp.sendRedirect("./detail");
			
			}else {
				out.print("incorrect username or pasword");
			}
		}catch(Exception e) {
			out.print("login required");
			
		}
		
		
		
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);

	}
	

}
