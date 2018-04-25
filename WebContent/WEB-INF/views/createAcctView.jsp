
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Resources/Styles/index_style.css"> 
</head>
<body>
<div class="container">
			<form method="POST" action="${pageContext.request.contextPath}/CreateAcctServlet" class="form-signin">
				<h1 class="form-signin-heading text-muted">Create Account</h1>
				<p id="SSNP">SSN</p>
				<input type="text" name="SSN" class="form-control" placeholder="ex. 111223333">
				<p id="FirstNameP">First Name</p>
				<input type="text" name="FirstName" class="form-control" placeholder="ex. John">
				<p id="LastNameP">Last Name</p>
				<input type="text" name="LastName" class="form-control" placeholder="ex. Doe">
				<p id="EmailP">Email</p>
				<input type="text" name="Email" class="form-control" placeholder="ex. JD123@gmail.com">
				<p id="PassWordP">PassWord</p>
				<input type="text" name="PassWord" class="form-control" placeholder="ex. abcd1234">
				<p id="AddressP">Address</p>
				<input type="text" name="Address" class="form-control" placeholder="ex. 123 Park Ave">
				<p id="CityP">City</p>
				<input type="text" name="City" class="form-control" placeholder="ex. Stony Brook">
				<p id="StateP">State</p>
				<input type="text" name="State" class="form-control" placeholder="ex. New York">
				<p id="ZipCodeP">ZipCode</p>
				<input type="text" name="ZipCode" class="form-control" placeholder="ex. 11780">
				<p id="TelephoneP">Telephone Number</p>
				<input type="text" name="Telephone" class="form-control" placeholder="ex. 1234567890">
				<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">
					Create Account
				</button>
				
			</form>
		</div>  
</body>
</html>