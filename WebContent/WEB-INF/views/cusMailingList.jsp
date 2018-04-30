<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" href="Resources/Styles/home_style.css"> 
	
	
	</head>
	<body>
	
	<div class="container">

<header>
	<button class="button">Log Out</button>
	<button class="button">Your Information</button>
	<img src="Resources/Images/qtlogoSmall.png" width=60 height=60 alt="QT Dating">
</header>

<nav>
  <ul>
    <li><a href="${pageContext.request.contextPath}/RecordDateServlet">Record a date</a></li>
    <li><a href="${pageContext.request.contextPath}/UpdateCusInfoServlet">Update customer information</a></li>
    <li><a href="${pageContext.request.contextPath}/CusMailingListServlet">Customer mailing lists</a></li>
    <li><a href="${pageContext.request.contextPath}/DateSuggServlet">Date suggestions for a profile</a></li>
  </ul>
</nav>	
		<h3>Customer Mailing list</h3>
		<table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>       
       </tr>
       <c:forEach items="${users}" var="user" >
          <tr>
             <td>${user.firstName}</td>
             <td>${user.lastName}</td>
             <td>${user.email}</td>
          </tr>
       </c:forEach>
    	</table>
    	<h3></h3>
		<a href="${pageContext.request.contextPath}/CusRepServlet" tabindex="5" class="login">Go Back To Home Page</a>
		
		<footer>
		</footer>
		</div>
	</body>
</html>