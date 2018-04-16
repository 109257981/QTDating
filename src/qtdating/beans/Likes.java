package qtdating.beans;

public class Likes {

	private String liker;
	private String likee;
	private String date_time;
	
	public Likes() {
		
	}
	
	public Likes(String liker, String likee, String date_time) {
		this.liker = liker;
		this.likee = likee;
		this.date_time = date_time;
	}

	public String getLiker() {
		return liker;
	}

	public void setLiker(String liker) {
		this.liker = liker;
	}

	public String getLikee() {
		return likee;
	}

	public void setLikee(String likee) {
		this.likee = likee;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	
}
