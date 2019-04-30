package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/update")

public class UpdateServ extends HttpServlet{
	

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session= req.getSession(false);
		
		if(session!=null) {
		
		ServletConfig config= getServletConfig();
		ServletContext cont= config.getServletContext();
	     Employee emp=(Employee)cont.getAttribute("em");
	     System.out.println(emp);
	     
		PrintWriter out =  resp.getWriter();
		resp.setContentType("text/html");	
		
		
		RequestDispatcher dis= req.getRequestDispatcher("/header.html");
	     dis.include(req, resp);
	 	
	     
	     int eid= Integer.parseInt(req.getParameter("id"));
		String pass = req.getParameter("password");
		String name = req.getParameter("name");
		ResultSet rs=null;
		Connection  con =null;
		PreparedStatement pstmt=null;
		
		try {
			java.sql.Driver driver= (java.sql.Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			
			//
			String dburl="jdbc:mysql://localhost:3306/Avengers?user=j2ee&password=1234";
			con=DriverManager.getConnection(dburl);
		
			
			//
			String query="update employee_table set e_password=? where e_id=? and e_name=?";
				
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, pass);
			pstmt.setInt(2, eid);
			pstmt.setString(3, name);
			
			int count=pstmt.executeUpdate();
			
			if(count>0)
			{
				out.print("update succesful");
			}else {
				out.print("update failed");
			}
	     
	     
	     
	}catch(Exception e) {
		e.printStackTrace();
	}
		}else {
			resp.sendRedirect("./log.html");
		}
	
	

	}
}
