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
		<h1>Home</h1>
		<h3>Hello Customer Representative <b>${person.email}</b></h3>
		<h3>Your Profiles</h3>
		
		<footer>
		</footer>
		</div>
	</body>
</html>