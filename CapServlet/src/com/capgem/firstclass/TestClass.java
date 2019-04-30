package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/o")
public class TestClass extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out =  resp.getWriter();
		resp.setContentType("text/html");
		
		
		
		
		String eid= req.getParameter("id");
		String pass = req.getParameter("password");
		
		ResultSet rs=null;
		Connection  con =null;
		PreparedStatement pstmt=null;
		
		try {
			java.sql.Driver driver= (java.sql.Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			
			//
			String dburl="jdbc:mysql://localhost:3306/Avengers?";
			con=DriverManager.getConnection(dburl,eid,pass);
			
			HttpSession session=req.getSession();
			req.setAttribute("f", session);
			
			Employee emp=new Employee(1234, "dinga", 31585);
			session.setAttribute("e", emp);
			
			
			//
			String query="select * from employee_table";
			pstmt=con.prepareStatement(query);
			
			
			rs=pstmt.executeQuery();
			
			req.setAttribute("rs", rs);
			
			if(rs!=null) {
			RequestDispatcher dis= req.getRequestDispatcher("/resultTestClass.jsp");
			dis.forward(req, resp);
			
			}else {
				resp.sendRedirect("/log.jsp");
			}
			
			
			
			
		} catch (Exception e) {
			out.print("incorrect password or usrname");
			e.printStackTrace();
		} finally {
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
		
		
		
		
	}

}
