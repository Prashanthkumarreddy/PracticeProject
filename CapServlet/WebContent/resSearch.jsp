<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Creating Fixed Header and Footer with CSS</title>
<style type="text/css">
/* Add some padding on document's body to prevent the content
    to go underneath the header and footer */
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.container {
	width: 80%;
	text-decoration: none;
	display: inline-block;
	color: #fff;
	margin: 0 auto; /* Center the DIV horizontally */
}

.fixed-header, .fixed-footer {
	width: 100%;
	position: fixed;
	background: #333;
	padding: 10px 0;
	color: #fff;
}

.fixed-header {
	top: 0;
}

.fixed-footer {
	bottom: 0;
}
/* Some more styles to beutify this example */
nav a {
	color: #fff;
	text-decoration: none;
	padding: 7px 25px;
	display: inline-block;
}

.container p {
	line-height: 200px; /* Create scrollbar to test positioning */
}
</style>
</head>
<body background="images/pargue.jpg">
	<div class="fixed-header">
		<div class="container">
			<nav>

				<a href="http://localhost:8080/CapServlet/he.jsp">Home</a> <a
					href="http://localhost:8080/CapServlet/signup.jsp">Add employee</a>
				<a href="http://localhost:8080/CapServlet/searchsecure">Search</a> <a
					href="http://localhost:8080/CapServlet/delete.jsp">Delete</a> <a
					href="http://localhost:8080/CapServlet/logout">LogOut</a>
			</nav>
		</div>
	</div>
	<div class="container">
		<p></p>
		<p></p>
	</div>

	<%!
    int id;
    String name;
    String dpt;
    int sal;
    int mgr;
    String desig;
    String city;
    
    %>


	<table border="1">
		<tr>
			<th>E_id</th>
			<th>E_name</th>
			<th>E_dpt</th>
			<th>E_sal</th>
			<th>E_mgr</th>
			<th>E_desig</th>
			<th>E_city</th>
		</tr>
		<%
Object obj=request.getAttribute("rs");
ResultSet rs=(ResultSet)obj;

while(rs.next()){
	id=rs.getInt("e_id");
	name=rs.getString("e_name");
	dpt=rs.getString("e_dept");
	sal=rs.getInt("e_sal");
	mgr=rs.getInt("e_mgr");
	desig=rs.getString("e_designation");
	city=rs.getString("e_city");
	
	%>

		<tr>
			<td><%=  id %></td>
			<td><%= name %></td>
			<td><%=  dpt %></td>
			<td><%= sal %></td>
			<td><%=  mgr %></td>
			<td><%= desig %></td>
			<td><%=  city %></td>
		</tr>

		<%} %>

</table>
<div class="fixed-footer">
		<div class="container">Copyright &copy; CapGeminiServlet @2018</div>
		<a class="container" align="right"
			href="http://localhost:8080/CapServlet/cont.jsp">Contact Us</a>
	</div>
</body>
</html>