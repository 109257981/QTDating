<nav>
<form method="GET" action="${pageContext.request.contextPath}/ProfQueryServlet" >

  <ul>
	<li><input type="submit" name="choice" value="New Geo-Date"/></li>
	<li><input type="submit" name="choice" value="Cancel a Date"/></li>
	<li><input type="submit" name="choice" value="Comment on a Date"/></li>
	<li><input type="submit" name="choice" value="Referral"/></li>
    <li><input type="submit" name="choice" value="Past Dates"/></li>
    <li><input type="submit" name="choice" value="Favorites List"/></li>
    <li><input type="submit" name="choice" value="Search for profiles"/></li>
    <li><input type="submit" name="choice" value="Most active profiles"/></li>
	<li><input type="submit" name="choice" value="Top Rated Profiles"/></li>
	<li><input type="submit" name="choice" value="Popular Date Locations"/></li>
	<li><input type="submit" name="choice" value="Date Suggestion List"/></li>
	<li><input type="submit" name="choice" value="Back to profiles"/></li>
	<input type="hidden" name="profileId" value="${profile.profileId}"/>
	
  </ul>
  </form>
  
  </nav>
  
  	<h1>Home</h1>
	<h3>Hello User <b>${person.email}</b></h3>
	<h3>Your ProfileID <b>${profile.profileId}</b></h3>