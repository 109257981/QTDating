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
		
			<form method="POST" action="${pageContext.request.contextPath}/RecordDateServlet" class="form-signin">
				<h1 class="form-signin-heading text-muted">Record A Date</h1>
				
				<input type="text" name="p1" class="form-control" placeholder="Profile 1">
				<input type="text" name="p2" class="form-control" placeholder="Profile 2">
				<input type="datetime" name="date" class="form-control" placeholder="yyyy-MM-dd HH:mm:ss">
				<input type="text" name="location" class="form-control" placeholder="Location">
				<input type="number" name="bkfee" class="form-control" placeholder="Booking Fee">
				<input type="text" name="cm" class="form-control" placeholder="Comments">
				<input type="number" name="u1R" class="form-control" placeholder="User1 Rating">
				<input type="number" name="u2R" class="form-control" placeholder="User2 Rating">
				
				<h5 class="form-signin-heading text-muted">Geo-Date</h5>
				<input type="radio" name="geo" value="Yes" checked> Yes<br>
  				<input type="radio" name="geo" value="No"> No<br>
  				<h5 class="form-signin-heading text-muted"></h5>	
		
				
				<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">
					Submit
				</button>
				<a href="${pageContext.request.contextPath}/CusRepServlet" tabindex="5" class="login">Go Back To Home Page</a> 
				<p style="color: red;">${errorString}</p>		
			</form>
		</div>    
	</body>
</html>