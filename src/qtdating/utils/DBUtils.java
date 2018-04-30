package qtdating.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import qtdating.beans.Account;
import qtdating.beans.BlindDate;
import qtdating.beans.Date;
import qtdating.beans.Employee;
import qtdating.beans.Likes;
import qtdating.beans.Person;
import qtdating.beans.Profile;
import qtdating.beans.User;
 
public class DBUtils {
	
	public static boolean runQuery(Connection conn, String sql) {
		try {
			conn.prepareStatement(sql).execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
    public static boolean personExists(Connection conn, String email) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE Email = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
 
        if (rs.next()) {
        	return true;
        }
        return false;
	}
	 
	public static Person getPerson(Connection conn, String email) {
		String sql = "SELECT * FROM Person WHERE Email = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String ssn = rs.getString("SSN");
				String password = rs.getString("Password");
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String street = rs.getString("Street");
				String city = rs.getString("City");
				String state = rs.getString("State");
				int zip = rs.getInt("ZipCode");
				String t_email = rs.getString("Email");
				String telephone = rs.getString("Telephone");
				return new Person(ssn, password, fname, lname, street, city, state, zip, t_email, telephone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Person getPerson(Connection conn, String email, String password) {
		String sql = "SELECT * FROM Person WHERE Email = ? AND Password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String ssn = rs.getString("SSN");
				String t_password = rs.getString("Password");
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String street = rs.getString("Street");
				String city = rs.getString("City");
				String state = rs.getString("State");
				int zip = rs.getInt("ZipCode");
				String t_email = rs.getString("Email");
				String telephone = rs.getString("Telephone");
				return new Person(ssn, t_password, fname, lname, street, city, state, zip, t_email, telephone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Person insertPerson(Connection conn, String SSN, String Password, String First, String Last,
										String Street, String City, String State, int Zipcode, String Email,
										String Telephone){
		
		String sql = "INSERT INTO Person(SSN, Password, FirstName, LastName, Street, City, State, Zipcode, Email, Telephone)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, SSN);
			ps.setString(2, Password);
			ps.setString(3, First);
			ps.setString(4, Last);
			ps.setString(5, Street);
			ps.setString(6, City);
			ps.setString(7, State);
			ps.setInt(8, Zipcode);
			ps.setString(9, Email);
			ps.setString(10, Telephone);
			ps.executeUpdate();
			return new Person(SSN, Password, First, Last, Street, City, State, Zipcode, Email, Telephone);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Employee getEmployee(Connection conn, String SSN) {
		String sql = "SELECT * FROM Employee WHERE SSN = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, SSN);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String ssn = rs.getString("SSN");
				String role = rs.getString("Role");
				String sd = rs.getString("StartDate");
				int hr = rs.getInt("HourlyRate");
				return new Employee(ssn, role, sd, hr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Profile> getProfile(Connection conn, String SSN){
		String sql = "SELECT * FROM Profile WHERE OwnerSSN = ?";
		ArrayList<Profile> profiles = new ArrayList<>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, SSN);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String profileID = rs.getString("ProfileID");
				String ssn = rs.getString("OwnerSSN");
				int age = rs.getInt("Age");
				int datingAgeRangeStart = rs.getInt("DatingAgeRangeStart");
				int datingAgeRangeEnd = rs.getInt("DatingAgeRangeEnd");
				int datingGeoRange = rs.getInt("DatinGeoRange");
				String m_F = rs.getString("M_F");
				String hobbies = rs.getString("Hobbies");
				int height = rs.getInt("Height");
				int weight = rs.getInt("Weight");
				String hairColor = rs.getString("HairColor");
				String creationDate = rs.getString("CreationDate");
				String lastModDate = rs.getString("LastModDate");
				profiles.add(new Profile(profileID, ssn, age, datingAgeRangeStart, datingAgeRangeEnd,
						datingGeoRange, m_F, hobbies, height, weight, hairColor, creationDate, lastModDate));
			}
			return profiles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Profile getSpecificProfile(Connection conn, String pID){
		String sql = "SELECT * FROM Profile WHERE ProfileID = ?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String profileID = rs.getString("ProfileID");
				String ssn = rs.getString("OwnerSSN");
				int age = rs.getInt("Age");
				int datingAgeRangeStart = rs.getInt("DatingAgeRangeStart");
				int datingAgeRangeEnd = rs.getInt("DatingAgeRangeEnd");
				int datingGeoRange = rs.getInt("DatinGeoRange");
				String m_F = rs.getString("M_F");
				String hobbies = rs.getString("Hobbies");
				int height = rs.getInt("Height");
				int weight = rs.getInt("Weight");
				String hairColor = rs.getString("HairColor");
				String creationDate = rs.getString("CreationDate");
				String lastModDate = rs.getString("LastModDate");
				return new Profile(profileID, ssn, age, datingAgeRangeStart, datingAgeRangeEnd,
						datingGeoRange, m_F, hobbies, height, weight, hairColor, creationDate, lastModDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Profile insertProfile(Connection conn, String pID, String ssn, int age, int datingAgeStart, int datingAgeEnd,
			int datingGeoRange, String m_F, String hobbies, int height, int weight, String hairColor,  Timestamp timestamp, Timestamp timestamp2){
		
		String sql = "INSERT INTO Profile(ProfileID, OwnerSSN, Age, DatingAgeRangeStart, DatingAgeRangeEnd, DatinGeoRange, M_F, Hobbies, Height, Weight, HairColor, CreationDate, LastModDate)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pID);
			ps.setString(2, ssn);
			ps.setInt(3, age);
			ps.setInt(4, datingAgeStart);
			ps.setInt(5, datingAgeEnd);
			ps.setInt(6, datingGeoRange);
			ps.setString(7, m_F);
			ps.setString(8, hobbies);
			ps.setInt(9, height);
			ps.setInt(10, weight);
			ps.setString(11, hairColor);
			ps.setObject(12, timestamp);
			ps.setObject(13, timestamp2);
			ps.executeUpdate();
			return new Profile(pID, ssn, age, datingAgeStart, datingAgeEnd, datingGeoRange, m_F, hobbies, height, weight, hairColor, timestamp.toString(),timestamp2.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
	public static ArrayList<Date> getPendingDates(Connection conn, String pID, String d_t){
		String sql = "SELECT * FROM Date WHERE Profile1 = ? OR Profile2 = ? AND Date_Time >= ?";
		ArrayList<Date> pendingDates = new ArrayList<>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pID);
			ps.setString(2, pID);
			ps.setString(3, d_t);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String p1 = rs.getString("Profile1");
				String p2 = rs.getString("Profile2");
				String custRep = rs.getString("CustRep");
				String dateTime = rs.getString("Date_Time");
				String loc = rs.getString("Location");
				int bookingFee = rs.getInt("BookingFee");
				String comments = rs.getString("Comments");
				int user1Rating = rs.getInt("User1Rating");
				int user2Rating = rs.getInt("User2Rating");
				boolean geoDate = rs.getBoolean("GeoDate");
				pendingDates.add(new Date(p1, p2, custRep, dateTime, loc, bookingFee, comments, user1Rating, user2Rating, geoDate));
			}
			return pendingDates;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean cancelDate(Connection conn, String p1, String p2, String d_t){
		String sql = "DELETE FROM Date WHERE Profile1 = ? AND Profile2 = ? AND Date_Time = ?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p1);
			ps.setString(2, p2);
			ps.setString(3, d_t);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean commentOnDate(Connection conn, String p1, String p2, String d_t, String comment){
		String sql = "UPDATE Date SET Comments = ? WHERE Profile1 = ? AND Profile2 = ? AND Date_Time = ?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comment);
			ps.setString(2, p1);
			ps.setString(3, p2);
			ps.setString(4, d_t);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean likeProfile(Connection conn, String liker, String likee, String d_t){
		String sql = "INSERT INTO Likes(Liker, Likee, Date_Time) VALUES(?,?,?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, liker);
			ps.setString(2, likee);
			ps.setString(3, d_t);
			ps.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Account createAccount(Connection conn, String ssn, String cardNumber, Timestamp timestamp){
		String sql = "INSERT INTO Account(OwnerSSN, CardNumber, AcctNum, AcctCreationDate) VALUES(?,?,?,?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ssn);
			ps.setString(2, cardNumber);
			String actNum = String.valueOf((int)(Math.random()*99999 + 10000));
			ps.setString(3, actNum);
			ps.setObject(4, timestamp);
			ps.executeUpdate();
			return new Account(ssn, cardNumber, actNum, timestamp.toString());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BlindDate referProfile(Connection conn, String profileA, String profileB, String profileC, String d_t){
		String sql = "INSER INTO BlindDate(ProfileA, ProfileB, ProfileC, Date_Time) VALUES(?,?,?,?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, profileA);
			ps.setString(2, profileB);
			ps.setString(3, profileC);
			ps.setString(4, d_t);
			ps.executeUpdate();
			return new BlindDate(profileA, profileB, profileC, d_t);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Date> getPastDates(Connection conn, String pID, String d_t){
		String sql = "SELECT * FROM Date WHERE Profile1 = ? OR Profile2 = ? AND Date_Time < ?";
		ArrayList<Date> pastDates = new ArrayList<>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pID);
			ps.setString(2, pID);
			ps.setString(3, d_t);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String p1 = rs.getString("Profile1");
				String p2 = rs.getString("Profile2");
				String custRep = rs.getString("CustRep");
				String dateTime = rs.getString("Date_Time");
				String loc = rs.getString("Location");
				int bookingFee = rs.getInt("BookingFee");
				String comments = rs.getString("Comments");
				int user1Rating = rs.getInt("User1Rating");
				int user2Rating = rs.getInt("User2Rating");
				boolean geoDate = rs.getBoolean("GeoDate");
				pastDates.add(new Date(p1, p2, custRep, dateTime, loc, bookingFee, comments, user1Rating, user2Rating, geoDate));
			}
			return pastDates;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Profile> getFavorites(Connection conn, String pID){
		String sql = "SELECT * FROM Profile P, Likes L WHERE P.ProfileID = L.Likee AND L.Liker = ?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pID);
			ResultSet rs = ps.executeQuery();
			ArrayList<Profile> profiles = new ArrayList<>();
			while(rs.next()){
				String profileID = rs.getString("ProfileID");
				String ssn = rs.getString("OwnerSSN");
				int age = rs.getInt("Age");
				int datingAgeRangeStart = rs.getInt("DatingAgeRangeStart");
				int datingAgeRangeEnd = rs.getInt("DatingAgeRangeEnd");
				int datingGeoRange = rs.getInt("DatinGeoRange");
				String m_F = rs.getString("M_F");
				String hobbies = rs.getString("Hobbies");
				int height = rs.getInt("Height");
				int weight = rs.getInt("Weight");
				String hairColor = rs.getString("HairColor");
				String creationDate = rs.getString("CreationDate");
				String lastModDate = rs.getString("LastModDate");
				profiles.add(new Profile(profileID, ssn, age, datingAgeRangeStart, datingAgeRangeEnd,
						datingGeoRange, m_F, hobbies, height, weight, hairColor, creationDate, lastModDate));
			}
			return profiles;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Profile> getProfileByAge(Connection conn, int ageStart, int ageEnd){
		String sql = "SELECT * FROM Profile WHERE age >= ? AND age <= ?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ageStart);
			ps.setInt(2, ageEnd);
			ResultSet rs = ps.executeQuery();
			ArrayList<Profile> profiles = new ArrayList<>();
			while(rs.next()){
				String profileID = rs.getString("ProfileID");
				String ssn = rs.getString("OwnerSSN");
				int age = rs.getInt("Age");
				int datingAgeRangeStart = rs.getInt("DatingAgeRangeStart");
				int datingAgeRangeEnd = rs.getInt("DatingAgeRangeEnd");
				int datingGeoRange = rs.getInt("DatinGeoRange");
				String m_F = rs.getString("M_F");
				String hobbies = rs.getString("Hobbies");
				int height = rs.getInt("Height");
				int weight = rs.getInt("Weight");
				String hairColor = rs.getString("HairColor");
				String creationDate = rs.getString("CreationDate");
				String lastModDate = rs.getString("LastModDate");
				profiles.add(new Profile(profileID, ssn, age, datingAgeRangeStart, datingAgeRangeEnd,
						datingGeoRange, m_F, hobbies, height, weight, hairColor, creationDate, lastModDate));
			}
			return profiles;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Profile> getProfileBySex(Connection conn, String sex){
		String sql = "SELECT * FROM Profile WHERE M_F = ?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sex);
			ResultSet rs = ps.executeQuery();
			ArrayList<Profile> profiles = new ArrayList<>();
			while(rs.next()){
				String profileID = rs.getString("ProfileID");
				String ssn = rs.getString("OwnerSSN");
				int age = rs.getInt("Age");
				int datingAgeRangeStart = rs.getInt("DatingAgeRangeStart");
				int datingAgeRangeEnd = rs.getInt("DatingAgeRangeEnd");
				int datingGeoRange = rs.getInt("DatinGeoRange");
				String m_F = rs.getString("M_F");
				String hobbies = rs.getString("Hobbies");
				int height = rs.getInt("Height");
				int weight = rs.getInt("Weight");
				String hairColor = rs.getString("HairColor");
				String creationDate = rs.getString("CreationDate");
				String lastModDate = rs.getString("LastModDate");
				profiles.add(new Profile(profileID, ssn, age, datingAgeRangeStart, datingAgeRangeEnd,
						datingGeoRange, m_F, hobbies, height, weight, hairColor, creationDate, lastModDate));
			}
			return profiles;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static User createUser(Connection conn, String ssn, String ppp, int rating, Timestamp timestamp){
		String sql = "INSERT INTO User1(SSN, PPP, Rating, DateOfLastAct) VALUES(?,?,?,?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ssn);
			ps.setString(2, ppp);
			ps.setInt(3, rating);
			ps.setObject(4, timestamp);
			ps.executeUpdate();
			return new User(ssn, ppp, rating, timestamp.toString());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Person> getAllUsers(Connection conn){
		String sql = "SELECT * FROM Person P WHERE P.SSN IN (SELECT U.SSN FROM User1 U)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Person> users = new ArrayList<>();
			while(rs.next()) {
				String ssn = rs.getString("SSN");
				String password = rs.getString("Password");
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String street = rs.getString("Street");
				String city = rs.getString("City");
				String state = rs.getString("State");
				int zip = rs.getInt("ZipCode");
				String t_email = rs.getString("Email");
				String telephone = rs.getString("Telephone");
				users.add(new Person(ssn, password, fname, lname, street, city, state, zip, t_email, telephone));
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean editUserInfo(Connection conn, String ssn, String change, String changeTo){
		//user table
		if(change.equals("PPP"))
		{
			String sql = "UPDATE User U SET U."+change+"=? WHERE U.SSN=?";
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, changeTo);
				ps.setString(2, ssn);
				int rowsUpdated = ps.executeUpdate();
				if (rowsUpdated > 0) {
				    return true;
				}
				else
				{
					return false;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			String sql = "UPDATE Person P SET P."+change+"=? WHERE P.SSN=?";
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, changeTo);
				ps.setString(2, ssn);
				int rowsUpdated = ps.executeUpdate();
				if (rowsUpdated > 0) {
				    return true;
				}
				else
				{
					return false;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

public static boolean deleteUser(Connection conn, String ssn){
		String sql = "DELETE FROM `Person` WHERE SSN=?";

		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ssn);
			int rowsdeleted = ps.executeUpdate();
			
			if (rowsdeleted> 0) {
			    return true;
			}
			else{
				return false;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	return false;
}

	public static ArrayList<Profile> getActiveProfiles(Connection conn){
		String sql = "SELECT * FROM Profile ORDER BY LastModDate DESC";
		ArrayList<Profile> profiles = new ArrayList<>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String profileID = rs.getString("ProfileID");
				String ssn = rs.getString("OwnerSSN");
				int age = rs.getInt("Age");
				int datingAgeRangeStart = rs.getInt("DatingAgeRangeStart");
				int datingAgeRangeEnd = rs.getInt("DatingAgeRangeEnd");
				int datingGeoRange = rs.getInt("DatinGeoRange");
				String m_F = rs.getString("M_F");
				String hobbies = rs.getString("Hobbies");
				int height = rs.getInt("Height");
				int weight = rs.getInt("Weight");
				String hairColor = rs.getString("HairColor");
				String creationDate = rs.getString("CreationDate");
				String lastModDate = rs.getString("LastModDate");
				profiles.add(new Profile(profileID, ssn, age, datingAgeRangeStart, datingAgeRangeEnd,
						datingGeoRange, m_F, hobbies, height, weight, hairColor, creationDate, lastModDate));
			}
			return profiles;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Profile> getHighlyRatedProfiles(Connection conn){
		String sql = "SELECT * FROM Profile P, (SELECT U.SSN FROM User U ORDER BY U.Rating DESC) AS OrderedSSN WHERE P.OwnerSSN = OrderedSSN.SSN";
		ArrayList<Profile> profiles = new ArrayList<>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String profileID = rs.getString("ProfileID");
				String ssn = rs.getString("OwnerSSN");
				int age = rs.getInt("Age");
				int datingAgeRangeStart = rs.getInt("DatingAgeRangeStart");
				int datingAgeRangeEnd = rs.getInt("DatingAgeRangeEnd");
				int datingGeoRange = rs.getInt("DatinGeoRange");
				String m_F = rs.getString("M_F");
				String hobbies = rs.getString("Hobbies");
				int height = rs.getInt("Height");
				int weight = rs.getInt("Weight");
				String hairColor = rs.getString("HairColor");
				String creationDate = rs.getString("CreationDate");
				String lastModDate = rs.getString("LastModDate");
				profiles.add(new Profile(profileID, ssn, age, datingAgeRangeStart, datingAgeRangeEnd,
						datingGeoRange, m_F, hobbies, height, weight, hairColor, creationDate, lastModDate));
			}
			return profiles;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getPopularGeoDateLocations(Connection conn){
		String sql = "SELECT D.Location FROM Date D GROUP BY D.Location ORDER BY COUNT(*) DESC LIMIT 5";
		ArrayList<String> locations = new ArrayList<>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String loc = rs.getString("Location");
				locations.add(loc);
			}
			return locations;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Profile> getPersonalizedDateSuggestions(Connection conn, int Age){
		int below = Age - 5;
		int above = Age + 5;
		String sql = "SELECT * FROM Profile P WHERE P.Age >= " + below + " AND P.Age <= " + above;
		ArrayList<Profile> profiles = new ArrayList<>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String profileID = rs.getString("ProfileID");
				String ssn = rs.getString("OwnerSSN");
				int age = rs.getInt("Age");
				int datingAgeRangeStart = rs.getInt("DatingAgeRangeStart");
				int datingAgeRangeEnd = rs.getInt("DatingAgeRangeEnd");
				int datingGeoRange = rs.getInt("DatinGeoRange");
				String m_F = rs.getString("M_F");
				String hobbies = rs.getString("Hobbies");
				int height = rs.getInt("Height");
				int weight = rs.getInt("Weight");
				String hairColor = rs.getString("HairColor");
				String creationDate = rs.getString("CreationDate");
				String lastModDate = rs.getString("LastModDate");
				profiles.add(new Profile(profileID, ssn, age, datingAgeRangeStart, datingAgeRangeEnd,
						datingGeoRange, m_F, hobbies, height, weight, hairColor, creationDate, lastModDate));
			}
			return profiles;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date insertDate(Connection conn,String profile1, String profile2, String custRep, Timestamp date_time, String location, int bookingFee,
			String comments, int user1Rating, int user2Rating, boolean geoDate)
	{
			String sql = "INSERT INTO Date(Profile1, Profile2, CustRep, Date_Time, Location, BookingFee, Comments, User1Rating, User2Rating,GeoDate)"
			+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, profile1);
				ps.setString(2, profile2);
				ps.setString(3, custRep);
				ps.setObject(4, date_time);
				ps.setString(5, location);
				ps.setInt(6, bookingFee);
				ps.setString(7, comments);
				ps.setInt(8, user1Rating);
				ps.setInt(9, user2Rating);
				ps.setBoolean(10, geoDate);
				ps.executeUpdate();
				return new Date(profile1, profile2,custRep, date_time.toString(),location, bookingFee,comments,user1Rating, user2Rating, geoDate);
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return null;
	}
	
	public static ArrayList<Profile> getProfileSugg(Connection conn, String pID){
		String sql = "SELECT * FROM Profile P WHERE P.ProfileID IN (SELECT D. Profile1 FROM Date D WHERE D.Profile2=?) UNION SELECT * FROM Profile P WHERE P.ProfileID IN (SELECT D. Profile2 FROM Date D WHERE D.Profile1=?)";
		ArrayList<Profile> profiles = new ArrayList<>();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pID);
			ps.setString(2, pID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String profileID = rs.getString("ProfileID");
				String ssn = rs.getString("OwnerSSN");
				int age = rs.getInt("Age");
				int datingAgeRangeStart = rs.getInt("DatingAgeRangeStart");
				int datingAgeRangeEnd = rs.getInt("DatingAgeRangeEnd");
				int datingGeoRange = rs.getInt("DatinGeoRange");
				String m_F = rs.getString("M_F");
				String hobbies = rs.getString("Hobbies");
				int height = rs.getInt("Height");
				int weight = rs.getInt("Weight");
				String hairColor = rs.getString("HairColor");
				String creationDate = rs.getString("CreationDate");
				String lastModDate = rs.getString("LastModDate");
				profiles.add(new Profile(profileID, ssn, age, datingAgeRangeStart, datingAgeRangeEnd,
						datingGeoRange, m_F, hobbies, height, weight, hairColor, creationDate, lastModDate));
			}
			return profiles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Person getCusGeneratedMostTotalRevenue(Connection conn) {
		String sql = "SELECT P.* FROM Person P WHERE P.SSN in ( SELECT K.OwnerSSN FROM Profile K WHERE K.ProfileID in ( SELECT K.Profile1 FROM ( SELECT M. Profile1, MAX(M.SUM) FROM ( SELECT K.Profile1, MAX(K.sum) as sum FROM ( SELECT J.Profile1, SUM(J.BookingFee) as sum   FROM ( SELECT D.Profile1, D.BookingFee FROM Date D UNION SELECT D.Profile2, D.BookingFee FROM Date D ) J GROUP BY J.Profile1 ) K GROUP BY K.Profile1 ORDER BY K.sum DESC) M )K ) ) ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String ssn = rs.getString("SSN");
				String password = rs.getString("Password");
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String street = rs.getString("Street");
				String city = rs.getString("City");
				String state = rs.getString("State");
				int zip = rs.getInt("ZipCode");
				String t_email = rs.getString("Email");
				String telephone = rs.getString("Telephone");
				return new Person(ssn, password, fname, lname, street, city, state, zip, t_email, telephone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Person> getCusWhoHaveDated(Connection conn) {
		String sql = "SELECT DISTINCT P.* FROM Person P, User1 U, Profile Pf, Date D WHERE (D.Profile1=Pf.ProfileID OR D.Profile2=Pf.ProfileID) AND Pf.OwnerSSN=P.SSN";
		ArrayList<Person> cus = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String ssn = rs.getString("SSN");
				String password = rs.getString("Password");
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String street = rs.getString("Street");
				String city = rs.getString("City");
				String state = rs.getString("State");
				int zip = rs.getInt("ZipCode");
				String t_email = rs.getString("Email");
				String telephone = rs.getString("Telephone");
				cus.add(new Person(ssn, password, fname, lname, street, city, state, zip, t_email, telephone));
			}
			return cus;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//get the top n highest rated customers
	public static ArrayList<User> getHighestRatedCus(Connection conn,int n) {
		String sql = "SELECT U.* FROM User1 U ORDER BY U.Rating DESC LIMIT "+n;
		ArrayList<User> cus = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String ssn = rs.getString("SSN");
				String ppp = rs.getString("PPP");
				int rating = rs.getInt("Rating");
				String date = rs.getString("DateOfLastAct");
				cus.add(new User(ssn, ppp,rating,date));
			}
			return cus;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Produce a list of the highest-rated calendar dates to have a date on
	public static ArrayList<String> getHighestRatedCalendarDate(Connection conn,int n) {
		
		String sql = "SELECT CAST(D.Date_Time as Date) AS \"Highest-rated calendar dates\" FROM Date D GROUP BY CAST(D.Date_Time as Date) ORDER BY COUNT(*) DESC LIMIT "+n;
		ArrayList<String> dates = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String date = rs.getString("Highest-rated calendar dates");
				dates.add(date);
			}
			return dates;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

