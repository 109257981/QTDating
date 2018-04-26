package qtdating.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import qtdating.beans.Employee;
import qtdating.beans.Person;
import qtdating.beans.Profile;
 
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
	
}