package qtdating.beans;

public class SuggestedBy {
	
	private String custRep;
	private String profile1;
	private String profile2;
	private String date_time;
	
	public SuggestedBy() {
		
	}

	public SuggestedBy(String custRep, String profile1, String profile2, String date_time) {
		this.custRep = custRep;
		this.profile1 = profile1;
		this.profile2 = profile2;
		this.date_time = date_time;
	}

	public String getCustRep() {
		return custRep;
	}

	public void setCustRep(String custRep) {
		this.custRep = custRep;
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

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	
}
