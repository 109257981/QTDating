<!DOCTYPE html>
<html>
	<head>
	<style>
div.container {
	background-color: white;
    width: 100%;
}

header,footer{
    padding: 1em;
    color: black;
    background-color: #d7dde5;
    clear: left;
    text-align: left;
}

nav {
    background-color: #d7dde5;
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
    border-style: solid;
    border-color: #a6a89f;
}

nav ul {
    list-style-type: none;
    padding: 0;
}
   
nav ul a {
    text-decoration: none;
}

.button {
    background-color: #f2b5c6;
    border: none;
    color: white;
    padding: 5px 15px;
    text-align: center;
    font-size: 16px;
    cursor: pointer;
    border-radius: 4px;
    float: right;
}

.button:hover {
    background-color: #8c2844;
}

</style>
	</head>
	<body>
	
	<div class="container">

<header>
	<button class="button">Log Out</button>
	<button class="button">Your Information</button>
	<h3>QT Dating</h3>
</header>

<nav>
  <ul>
    <li><a href="#">Create New Profile</a></li>
    <li><a href="#">Pending Dates</a></li>
    <li><a href="#">Past Dates</a></li>
    <li><a href="#">Past Dates</a></li>
    <li><a href="#">Favorites List</a></li>
    <li><a href="#">Search For Profiles</a></li>
    <li><a href="#">Most Active Profiles</a></li>
    <li><a href="#">Most Highly Rated Profiles</a></li>
    <li><a href="#">Popular Geo-date Locations</a></li>
    <li><a href="#">Personalized Date Suggestion List</a></li>
  </ul>
</nav>
		<h1>Home</h1>
		<h3>Hello <b>${person.email}</b></h3>
		<h3>Your Profiles</h3>
		
		<footer>
		</footer>
		</div>
	</body>
</html>