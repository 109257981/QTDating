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
	<form method="GET" action="${pageContext.request.contextPath}/LogOutServlet">
		<button class="button" type="submit">Log Out</button>
	</form>
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
		
		<form method="POST" action="${pageContext.request.contextPath}/UpdateCusInfoServlet" class="form-signin">
		<select id="option" name="option">
			  <option value="add">Add a customer</option>
			  <option value="edit">Edit information of a customer</option>
			  <option value="delete">Delete a customer </option>
		</select>
		<input type="submit" value="Submit">
		</form>
		<a href="${pageContext.request.contextPath}/CusRepServlet" tabindex="5" class="login">Go Back To Home Page</a>		
		<footer>
		</footer>
		</div>
	</body>
</html>