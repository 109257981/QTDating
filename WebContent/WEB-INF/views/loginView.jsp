<!DOCTYPE html>
<html>
	<head>
<link rel="stylesheet" href="Resources/Styles/index_style.css"> 

	</head>
	<body>
	
		<div class="container">
			<form method="POST" action="${pageContext.request.contextPath}/LoginServlet" class="form-signin">
				<h1 class="form-signin-heading text-muted">Log In</h1>
				<input type="text" name="Email" class="form-control" placeholder="Email">
				<input type="password" name="Password" class="form-control" placeholder="Password">
				<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">
					Log In
				</button>
			</form>
		</div>    
	</body>
</html>