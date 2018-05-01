
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
          <th>Profile ID</th>
          <th>Gender</th>
          <th>Age</th>
          <th>Weight</th>
          <th>Height</th>
       </tr>
       <c:forEach items="${profileList}" var="profile" >
          <tr>
             <td>${profile.profileId}</td>
             <td>${profile.m_f}</td>
             <td>${profile.age}</td>
             <td>${profile.weight}</td>
             <td>${profile.height}</td>
             <td>
             	<form>
             		<button name="choice" type="submit" value="Make a Date">Make a Date</button>
             		<input type="hidden" name="profile2" value="${profile.profileId}"> 
             	</form>  
             </td>        
          </tr>
       </c:forEach>
    	</table>
		</div>
	</body>
</html>
