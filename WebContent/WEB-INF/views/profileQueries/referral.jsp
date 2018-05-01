
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
	  
	  	<form method="GET" action="${pageContext.request.contextPath}/ProfQueryServlet" >
         <h2>Refer Profile A</h2>
          <input type="text" name="profileA">
          <h2>To Profile B </h2>
          <input type="text" name="profileB">
          <input type="submit" name="choice" value="Refer">
          </form> 
          
           
            

	   


		
	
		</div>
	</body>
</html>
