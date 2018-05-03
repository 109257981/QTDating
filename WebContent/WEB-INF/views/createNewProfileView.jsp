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
		
			<form method="POST" action="${pageContext.request.contextPath}/CreateNewProfileServlet" class="form-signin">
				<h1 class="form-signin-heading text-muted">Create A New Profile</h1>
				
				<input type="text" name="profileId" class="form-control" placeholder="Your Profile ID">
				<input type="number" name="age" class="form-control" placeholder="Age">
				<input type="number" name="datingAgeRangeStart" class="form-control" placeholder="Dating Age Range Start">
				<input type="number" name="datingAgeRangeEnd" class="form-control" placeholder="Dating Age Range End">
				<input type="number" name="datingGeoRange" class="form-control" placeholder="Dating Geo Range">
	
				<h5 class="form-signin-heading text-muted">Your Gender</h5>
				<input type="radio" name="m_f" value="Male" checked> Male<br>
  				<input type="radio" name="m_f" value="Female"> Female<br>
  				<h5 class="form-signin-heading text-muted"></h5>
				
				<input type="text" name="hobbies" class="form-control" placeholder="Your Hobbies">
				<input type="number" name="height" class="form-control" placeholder="Your Height">
				<input type="number" name="weight" class="form-control" placeholder="Your Weight">
				<input type="text" name="hairColor" class="form-control" placeholder="Your Hair Color">
				
				<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">
					Submit
				</button>
				 
				<p style="color: red;">${errorString}</p>
			</form>
		</div>    
	</body>
</html>