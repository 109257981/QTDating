
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
          <th>Customer Representative</th>
          <th>Date and Time</th>
          <th>Location</th>
          <th>Booking Fee</th>
       </tr>
       <c:forEach items="${pendingDates}" var="date" >
          <tr>
             <td>${date.profile2}</td>
             <td>${date.custRep}</td>
             <td>${date.date_time}</td>
             <td>${date.location}</td>
             <td>${date.bookingFee}</td>             
          </tr>
       </c:forEach>
    	</table>
	   


		
	
		</div>
	</body>
</html>
