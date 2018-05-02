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
    <li><a href="${pageContext.request.contextPath}/RecordDateServlet">Record a date</a></li>
    <li><a href="${pageContext.request.contextPath}/UpdateCusInfoServlet">Update customer information</a></li>
    <li><a href="${pageContext.request.contextPath}/CusMailingListServlet">Customer mailing lists</a></li>
    <li><a href="${pageContext.request.contextPath}/DateSuggServlet">Date suggestions for a profile</a></li>
  </ul>
</nav>

		<form method="POST" action="${pageContext.request.contextPath}/DateSuggServlet" class="form-signin">
				<h1 class="form-signin-heading text-muted">Produce a list of profiles as date suggestions for a given profile</h1>
				<input type="text" name="pID" class="form-control" placeholder="Enter the ProfileID">			
				<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">
					Submit
				</button>
				<p style="color: red;">${errorString}</p>		
			</form>
		
		<table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>ProfileID</th>
          <th>Age</th>
          <th>DatingAgeRangeStart</th>
          <th>DatingAgeRangeEnd</th>
          <th>DatinGeoRange</th>
          <th>M_F</th>
          <th>Hobbies</th>
          <th>Height</th>
          <th>Weight</th>
          <th>HairColor</th>
          <th>CreationDate</th>
          <th>LastModDate</th>
       </tr>
       <c:forEach items="${profileList}" var="profile" >
          <tr>
             <td>${profile.profileId}</td>
             <td>${profile.age}</td>
             <td>${profile.datingAgeRangeStart}</td>
             <td>${profile.datingAgeRangeEnd}</td>
             <td>${profile.datingGeoRange}</td>
             <td>${profile.m_f}</td>
             <td>${profile.hobbies}</td>
             <td>${profile.height}</td>
             <td>${profile.weight}</td>
             <td>${profile.hairColor}</td>
             <td>${profile.creationDate}</td>
             <td>${profile.lastModDate}</td>
          </tr>
       </c:forEach>
    	</table>
		<a href="${pageContext.request.contextPath}/CusRepServlet" tabindex="5" class="login">Go Back To Home Page</a> 
	
		<footer>
		</footer>
		</div>
	</body>
</html>