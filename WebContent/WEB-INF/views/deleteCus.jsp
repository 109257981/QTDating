<!DOCTYPE html>
<html>
	<head>
<link rel="stylesheet" href="Resources/Styles/home_style.css">  

	</head>
	<body>
	
		<div class="container">
		
		<header>
			<form method="GET" action="${pageContext.request.contextPath}/LogOutServlet">
		<button class="button" type="submit">Log Out</button>
		</form>
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
		
			<form method="POST" action="${pageContext.request.contextPath}/DeleteCusServlet" class="form-signin">
				<h1 class="form-signin-heading text-muted">Delete A Customer</h1>
				
				<input type="text" name="SSN" class="form-control" placeholder="Customer's SSN">
				<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">
					Submit
				</button>
				 
				 <a href="${pageContext.request.contextPath}/CusRepServlet" tabindex="5" class="login">Go Back To Home Page</a>
				<p style="color: red;">${errorString}</p>
				
			</form>
		</div>    
	</body>
</html>