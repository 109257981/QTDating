
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" href="Resources/Styles/profile_style.css"> 
	</head>
	
	<body>
	<div class="container">
	
		
	
	   <%@include  file="/WEB-INF/views/manHeader.jsp" %>	
	   <%@include  file="/WEB-INF/views/manNavigation.jsp" %>	
	<form method="GET" action="${pageContext.request.contextPath}/ManagerQueryServlet">
		  <input type="date" name="date">
		  <input type="hidden" name="how" value="date">
          <input type="submit" name="choice" value="DateSearchResult">
	</form>
		<form method="GET" action="${pageContext.request.contextPath}/ManagerQueryServlet">
		  <input type="text" name="firstName"  placeholder="First Name">
		  <input type="text" name="lastName"  placeholder="Last Name">
		  <input type="hidden" name="how" value="name">
          <input type="submit" name="choice" value="DateSearchResult">
	</form>
	
	</div>
	</body>
</html>
