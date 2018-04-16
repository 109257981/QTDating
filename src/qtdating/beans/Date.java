package qtdating.beans;

public class Date {

	private String profile1;
	private String profile2;
	private String custRep;
	private String date_time;
	private String location;
	private int bookingFee;
	private String comments;
	private int user1Rating;
	private int user2Rating;
	private boolean geoDate;
	
	public Date() {
		
	}

	public Date(String profile1, String profile2, String custRep, String date_time, String location, int bookingFee,
			String comments, int user1Rating, int user2Rating, boolean geoDate) {
		this.profile1 = profile1;
		this.profile2 = profile2;
		this.custRep = custRep;
		this.date_time = date_time;
		this.location = location;
		this.bookingFee = bookingFee;
		this.comments = comments;
		this.user1Rating = user1Rating;
		this.user2Rating = user2Rating;
		this.geoDate = geoDate;
	}

	public String getProfile1() {
		return profile1;
	}

	public void setProfile1(String profile1) {
		this.profile1 = profile1;
	}

	public String getProfile2() {
		return profile2;
	}

	public void setProfile2(String profile2) {
		this.profile2 = profile2;
	}

	public String getCustRep() {
		return custRep;
	}

	public void setCustRep(String custRep) {
		this.custRep = custRep;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getBookingFee() {
		return bookingFee;
	}

	public void setBookingFee(int bookingFee) {
		this.bookingFee = bookingFee;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getUser1Rating() {
		return user1Rating;
	}

	public void setUser1Rating(int user1Rating) {
		this.user1Rating = user1Rating;
	}

	public int getUser2Rating() {
		return user2Rating;
	}

	public void setUser2Rating(int user2Rating) {
		this.user2Rating = user2Rating;
	}

	public boolean isGeoDate() {
		return geoDate;
	}

	public void setGeoDate(boolean geoDate) {
		this.geoDate = geoDate;
	}
	
	
}
