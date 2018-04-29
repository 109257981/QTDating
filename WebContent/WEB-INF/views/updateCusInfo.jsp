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
    <li><a href="#">Record a date</a></li>
    <li><a href="${pageContext.request.contextPath}/UpdateCusInfoServlet">Update customer information</a></li>
    <li><a href="${pageContext.request.contextPath}/CusMailingListServlet">Customer mailing lists</a></li>
    <li><a href="#">Date suggestions for a profile</a></li>
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