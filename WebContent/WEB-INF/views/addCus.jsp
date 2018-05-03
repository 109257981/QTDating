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
		
			<form method="POST" action="${pageContext.request.contextPath}/AddCusServlet" class="form-signin">
				<h1 class="form-signin-heading text-muted">Add A Customer</h1>
				
				<input type="text" name="SSN" class="form-control" placeholder="SSN">
				<input type="number" name="PassWord" class="form-control" placeholder="Password">
				<input type="number" name="ConfirmPass" class="form-control" placeholder="Confirm Password">
				<input type="text" name="FirstName" class="form-control" placeholder="First Name">
				<input type="text" name="LastName" class="form-control" placeholder="Last Name">
				<input type="text" name="Address" class="form-control" placeholder="Street">
				<input type="text" name="City" class="form-control" placeholder="City">
				<input type="text" name="State" class="form-control" placeholder="State">
				<input type="number" name="ZipCode" class="form-control" placeholder="Zip Code">	
				<input type="text" name="Email" class="form-control" placeholder="Email">
				<input type="number" name="Telephone" class="form-control" placeholder="Telephone">
				<input type="number" name="Cardnumber" class="form-control" placeholder="Card Number">
				
				<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">
					Submit
				</button>
				<a href="${pageContext.request.contextPath}/CusRepServlet" tabindex="5" class="login">Go Back To Home Page</a> 
				<p style="color: red;">${errorString}</p>		
			</form>
		</div>    
	</body>
</html>