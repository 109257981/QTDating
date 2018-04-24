<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QTDating</title>
<style>
body {
    background: #f959f9;
}

h1 {
	font-size: 80px;
	text-align: center;
}

a {
     text-align: center;
     display: block;
     font-size: 25px;
}
</style>
</head>
<body>
 
  <h1>QTDating</h1>

   <a href="${pageContext.request.contextPath}/LoginServlet" tabindex="5" class="login">Login</a>
   <a href="${pageContext.request.contextPath}/CreateAcctServlet" tabindex="5" class="login">Create Account</a>
   
</body>
</html>