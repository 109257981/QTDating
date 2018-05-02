<nav>
<form method="GET" action="${pageContext.request.contextPath}/ManagerQueryServlet" >

  <ul>
	<li><input type="submit" name="choice" value="Update Employee Information"/></li>
	<li><input type="submit" name="choice" value="Monthly Sales"/></li>
	<li><input type="submit" name="choice" value="All Users"/></li>
	<li><input type="submit" name="choice" value="All Dates"/></li>
    <li><input type="submit" name="choice" value="Revenue summary"/></li>
    <li><input type="submit" name="choice" value="Employee revenue rating"/></li>
    <li><input type="submit" name="choice" value="Most Active Customers"/></li>
    <li><input type="submit" name="choice" value="Hightly Rated Customers"/></li>
	<li><input type="submit" name="choice" value="Dates Between Customers"/></li>
	<li><input type="submit" name="choice" value="Highest-Rated Calendar Dates"/></li>
	
  </ul>
  </form>
  
  </nav>
  
   	<h1>Home</h1>
	<h3>Hello Manager,  <b>${person.firstName}</b></h3>
	
	
  