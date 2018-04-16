package qtdating.beans;

public class Employee {
	
	private String ssn;
	private String role;
	private String startDate;
	private int hourlyRate;
	
	public Employee() {
		
	}
	
	public Employee(String ssn, String role, String startDate, int hourlyRate) {
		this.ssn = ssn;
		this.role = role;
		this.startDate = startDate;
		this.hourlyRate = hourlyRate;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	
}
