<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Creating Fixed Header and Footer with CSS</title>
<style type="text/css">
    /* Add some padding on document's body to prevent the content
    to go underneath the header and footer */
    body{        
        padding-top: 60px;
        padding-bottom: 40px;
       
    }
    .container{
        width: 80%;
        margin: 0 auto; /* Center the DIV horizontally */
    }
    .fixed-header, .fixed-footer{
        width: 100%;
        position: fixed;        
        background: #333;
        padding: 10px 0;
        color: #fff;
    }
    .fixed-header{
        top: 0;
    }
    .fixed-footer{
        bottom: 0;
    }    
    /* Some more styles to beutify this example */
    nav a{
        color: #fff;
        text-decoration: none;
        padding: 7px 25px;
        display: inline-block;
    }
    .container p{
        line-height: 200px; /* Create scrollbar to test positioning */
    }
    
</style>
</head>
<body background="images/phuket.thailand.jpg">
    <div class="fixed-header">
        <div class="container">
            <nav>
                <a href="http://localhost:8080/CapServlet/update.jsp">Update</a>
                <a href="http://localhost:8080/CapServlet/he.jsp">Home</a>
                <a href="http://localhost:8080/CapServlet/signup.jsp">Add employee</a>
                <a href="http://localhost:8080/CapServlet/search.jsp">Search</a>
                <a href="http://localhost:8080/CapServlet/delete.jsp">Delete</a>
               
            </nav>
        </div>
    </div>
    <div class="container">
    	<p></p>
        <p></p>
    </div>   
    <form method="post" action="http://localhost:8080/CapServlet/d">
	<table border="0" cellspacing="10px" align="center">
  <tr>
  <td>employee id:<input type="number" name="id" placeholder="enter the user name"></td>
  <tr>
  <td>Password:<input type="password" name="password"/></td>
  </tr>
  <tr>
  <td><button type="submit" value="Delete">Delete</button></td>
  </tr>
  </table>
  </form> 
    <div class="fixed-footer">
        <div class="container">Copyright &copy; CapGeminiServlet @2018 </div> 
         <a href="http://localhost:8080/CapServlet/cont.jsp">Contact Us</a>       
    </div>
</body>
</html> 