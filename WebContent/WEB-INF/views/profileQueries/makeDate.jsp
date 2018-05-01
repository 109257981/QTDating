
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
			<br> <input name="date" type="date">  <br>
			<br> <input name="time" type="time">  <br>
			<br> <input name="location" type="text" placeholder="Location">  <br>
			<br>
			<button name="choice" value="submitNewDate" type="submit">Make a Date!</button>
			<input name="profile2" type="hidden" value="${profile2}">  <br>
		</form>
		

	</div>
</body>
</html>
