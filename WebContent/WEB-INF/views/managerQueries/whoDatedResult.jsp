
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
	  
	    <table border="1">
	    <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>State</th>
          <th>City</th>
          <th>Email</th>
          <th>Phone #</th>
       </tr>
       <c:forEach items="${users}" var="user" >
          <tr>
             <td>${user.firstName}</td>
             <td>${user.lastName}</td>
             <td>${user.state}</td>
             <td>${user.city}</td>
             <td>${user.email}</td>
             <td>${user.telephone}</td>
          </tr>
       </c:forEach>
    	</table>
	   
	             


		

		</div>
	</body>
</html>
