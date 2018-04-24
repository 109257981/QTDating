<!DOCTYPE html>
<html>
	<head>
	<style>
		body {
		    background: #f959f9;
		}
		h1 {
			font-size: 80px;
			text-align: center;
		}
		a {
		     text-align: center;
		     display: block;
		     font-size: 25px;
		}
		input {
			display: block;
			margin: 0 auto;
		}
		button {
			display: block;
			margin: 0 auto;
		}
		
	</style>
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