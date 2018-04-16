package qtdating.beans;

public class Profile {
	
	private String profileId;
	private String ownerSSN;
	private int age;
	private int datingAgeRangeStart;
	private int datingAgeRangeEnd;
	private int datingGeoRange;
	private String m_f;
	private String hobbies;
	private int height;
	private int weight;
	private String hairColor;
	private String creationDate;
	private String lastModDate;
	
	public Profile() {
		
	}

	public Profile(String profileId, String ownerSSN, int age, int datingAgeRangeStart, int datingAgeRangeEnd,
			int datingGeoRange, String m_f, String hobbies, int height, int weight, String hairColor,
			String creationDate, String lastModDate) {
		this.profileId = profileId;
		this.ownerSSN = ownerSSN;
		this.age = age;
		this.datingAgeRangeStart = datingAgeRangeStart;
		this.datingAgeRangeEnd = datingAgeRangeEnd;
		this.datingGeoRange = datingGeoRange;
		this.m_f = m_f;
		this.hobbies = hobbies;
		this.height = height;
		this.weight = weight;
		this.hairColor = hairColor;
		this.creationDate = creationDate;
		this.lastModDate = lastModDate;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getOwnerSSN() {
		return ownerSSN;
	}

	public void setOwnerSSN(String ownerSSN) {
		this.ownerSSN = ownerSSN;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDatingAgeRangeStart() {
		return datingAgeRangeStart;
	}

	public void setDatingAgeRangeStart(int datingAgeRangeStart) {
		this.datingAgeRangeStart = datingAgeRangeStart;
	}

	public int getDatingAgeRangeEnd() {
		return datingAgeRangeEnd;
	}

	public void setDatingAgeRangeEnd(int datingAgeRangeEnd) {
		this.datingAgeRangeEnd = datingAgeRangeEnd;
	}

	public int getDatingGeoRange() {
		return datingGeoRange;
	}

	public void setDatingGeoRange(int datingGeoRange) {
		this.datingGeoRange = datingGeoRange;
	}

	public String getM_f() {
		return m_f;
	}

	public void setM_f(String m_f) {
		this.m_f = m_f;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(String lastModDate) {
		this.lastModDate = lastModDate;
	}
	
	
}
