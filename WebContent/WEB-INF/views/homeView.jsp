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
    <li><a href="${pageContext.request.contextPath}/CreateNewProfileServlet">Create New Profile</a></li>
  </ul>
</nav>
		<h1>Home</h1>
		<h3>Hello User <b>${person.email}</b></h3>
		<h3>Your Profiles</h3>
		
		<form method="GET" action="${pageContext.request.contextPath}/ProfileServlet">
		
		<table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>ProfileID</th>
          <th>CreationDate</th>
          <th>LastModDate</th>
          <th></th>
       </tr>
       <c:forEach items="${profileList}" var="profile" >
          <tr>
             <td>${profile.profileId}</td>
             <td>${profile.creationDate}</td>
             <td>${profile.lastModDate}</td>
             
             <td><button name="btn" type="submit" value="${profile.profileId}">Use</button></td>
             
          </tr>
       </c:forEach>
    	</table>
		
		</form>
		
		<footer>
		</footer>
		</div>
	</body>
</html>