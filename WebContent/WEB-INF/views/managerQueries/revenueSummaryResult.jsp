
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
	   
	 <h1>  Total Revenue Generated: ${total}</h1>
	
	
	</div>
	</body>
</html>
