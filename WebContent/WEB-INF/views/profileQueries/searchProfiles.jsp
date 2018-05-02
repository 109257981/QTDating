
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Resources/Styles/profile_style.css">


</head>

<body>
	<div class="container">

		<%@include file="/WEB-INF/views/profHeader.jsp"%>
		<%@include file="/WEB-INF/views/profNavigation.jsp"%>
		
	


		<form method="GET" action="${pageContext.request.contextPath}/ProfQueryServlet">
			<br> <input name="name" type="text" placeholder="Profile Name">
			<br>
			<br> 
				 <input name="ageStart" type="text" placeholder="Age From">
			     <input name="ageEnd"   type="text" placeholder="Age From">  
			<br>
			<br>    
				<input name="weightStart" type="text" placeholder="Weight From">
			  	<input name="weightEnd"   type="text" placeholder="To">
			<br>
			<br>
				<input name="heightStart" type="text" placeholder="Height From">
			  	<input name="heightEnd"   type="text" placeholder="To">
			<br>
			<br>
			<button name="choice" value="searchProfilesResult" type="submit">Search!</button>
		</form>
		

	</div>
</body>
</html>
