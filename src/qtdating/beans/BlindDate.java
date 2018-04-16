package qtdating.beans;

public class BlindDate {
	
	private String profileA;
	private String profileB;
	private String profileC;
	private String date_time;
	
	public BlindDate() {
		
	}

	public BlindDate(String profileA, String profileB, String profileC, String date_time) {
		this.profileA = profileA;
		this.profileB = profileB;
		this.profileC = profileC;
		this.date_time = date_time;
	}

	public String getProfileA() {
		return profileA;
	}

	public void setProfileA(String profileA) {
		this.profileA = profileA;
	}

	public String getProfileB() {
		return profileB;
	}

	public void setProfileB(String profileB) {
		this.profileB = profileB;
	}

	public String getProfileC() {
		return profileC;
	}

	public void setProfileC(String profileC) {
		this.profileC = profileC;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	

}
