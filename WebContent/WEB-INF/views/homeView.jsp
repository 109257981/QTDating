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
    <li><a href="#">Create New Profile</a></li>
  </ul>
</nav>
		<h1>Home</h1>
		<h3>Hello User <b>${person.email}</b></h3>
		<h3>Your Profiles</h3>
		
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
             <td><a href="#">${profile.profileId}</a></td>
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
		
		<footer>
		</footer>
		</div>
	</body>
</html>