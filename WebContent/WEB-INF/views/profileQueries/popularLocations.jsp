
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
	
		
	
	   <%@include  file="/WEB-INF/views/profHeader.jsp" %>	
	   <%@include  file="/WEB-INF/views/profNavigation.jsp" %>	
	  
	    <table border="1">
	    <tr>
          <th>Locations</th>
     
       </tr>
       <c:forEach items="${locations}" var="location" >
          <tr>
             <td>${location}</td>    
          </tr>
       </c:forEach>
    	</table>
	   


		

		</div>
	</body>
</html>
