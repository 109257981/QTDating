package qtdating.beans;

public class User {

	private String ssn;
	private String ppp;
	private int rating;
	private String dateOfLastAct;
	
	public User() {
		
	}

	public User(String ssn, String ppp, int rating, String dateOfLastAct) {
		this.ssn = ssn;
		this.ppp = ppp;
		this.rating = rating;
		this.dateOfLastAct = dateOfLastAct;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPpp() {
		return ppp;
	}

	public void setPpp(String ppp) {
		this.ppp = ppp;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDateOfLastAct() {
		return dateOfLastAct;
	}

	public void setDateOfLastAct(String dateOfLastAct) {
		this.dateOfLastAct = dateOfLastAct;
	}
	
	
	
}
