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
		
			<form method="POST" action="${pageContext.request.contextPath}/EditCusServlet" class="form-signin">
				<h1 class="form-signin-heading text-muted">Edit Information of a Customer</h1>
				
				<input type="text" name="SSN" class="form-control" placeholder="Customer's SSN">
				<select id="change" name="change">
					  <option value="Password">Password</option>
					  <option value="FirstName">First Name</option>
					  <option value="LastName">Last Name</option>
					  <option value="Street">Street</option>
					  <option value="City">City</option>
					  <option value="State">State</option>
					  <option value="Zipcode">Zip Code</option>
					  <option value="Email">Email</option>
					  <option value="Telephone">Telephone</option>
					  <option value="PPP">Profile Placement Priority</option>
				</select>
				
				<input type="text" name="changeTo" class="form-control" placeholder="Change it to">
				<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">
					Submit
				</button>
				 
				 <a href="${pageContext.request.contextPath}/CusRepServlet" tabindex="5" class="login">Go Back To Home Page</a>
				<p style="color: red;">${errorString}</p>
				
			</form>
		</div>    
	</body>
</html>