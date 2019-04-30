package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/xyz")

public class Search extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	HttpSession session= req.getSession(false);
	ServletConfig config = getServletConfig(); 
	ServletContext cont=config.getServletContext();
	Employee em=new Employee(662, "dingi", 12150);
	cont.setAttribute("em", em);
	
	Employee empp=new Employee(62, "somesh", 12150);
   req.setAttribute("emp", empp);
	
	
	if(session!=null) {
		
	
	Employee emp=(Employee)session.getAttribute("e");
	System.out.println(emp);
	
	
	PrintWriter out =resp.getWriter();
	resp.setContentType("text/html");
	int eid= Integer.parseInt(req.getParameter("id"));
	String pass=req.getParameter("password");

     
     
	
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
		String query="select * from employee_table where e_id=? and e_password=?";
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1,eid );
		pstmt.setString(2, pass);
		
		
		rs=pstmt.executeQuery();
		req.setAttribute("rs", rs);
		
		if(rs!=null) {
			
			RequestDispatcher dis= req.getRequestDispatcher("/resSearch.jsp");
		     dis.include(req, resp);
			
			
			
				
			}else {
				resp.sendRedirect("http://localhost:8080/CapServlet/search.html");
			}
}
	
	
	

catch(Exception e) {
	
	
}finally {
	
	if(con!=null) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(pstmt!=null) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(rs!=null) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	}else{
		resp.sendRedirect("./log.html");
	}
}
}
