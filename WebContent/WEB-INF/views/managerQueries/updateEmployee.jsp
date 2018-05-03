
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
	
		
	
	   <%@include  file="/WEB-INF/views/manHeader.jsp" %>	
	   <%@include  file="/WEB-INF/views/manNavigation.jsp" %>	
	<form>
          <input type="text" name="ssn" placeholder="SSN">
          <input type="text" name="role" placeholder="Role">
          <input type="text" name="rate" placeholder="Hourly Rate">
          <input type="submit" name="choice" value="UpdateEmployee" placeholder="Update">
          <input type="submit" name="choice" value="DeleteEmployee" placeholder="Delete">
	</form>

		</div>
	</body>
</html>
