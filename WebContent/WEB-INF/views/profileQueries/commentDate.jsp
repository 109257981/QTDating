
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
          <th>Partner's id</th>
          <th>Date and Time</th>
          <th>Location</th>
          <th>Current Comment</th>
          <th>New Comment</th>
          
      
          <th></th>
       </tr>
       <c:forEach items="${pastDates}" var="date" >
          <tr>
   
             <td>${date.profile2}</td>
             <td>${date.date_time}</td>
             <td>${date.location}</td>
             <td>${date.comments}</td>
             <td><form method="GET" action="${pageContext.request.contextPath}/ProfQueryServlet" >
             <input type="hidden" name="profile1" value="${date.profile1}">
             <input type="hidden" name="profile2" value="${date.profile2}">
             <input type="hidden" name="date" value="${date.date_time}">
             <input type="text" name="comment">
             <input type="submit" name="choice" value="newComment">
             </form> 
             
             </td>
             
          </tr>
       </c:forEach>
    	</table>
	   


		
	
		</div>
	</body>
</html>
