package qtdating.beans;

public class Account {
	
	private String ownerSSN;
	private String cardNumber;
	private String accountNum;
	private String accountCreationDate;
	
	public Account() {
		
	}

	public Account(String ownerSSN, String cardNumber, String accountNum, String accountCreationDate) {
		this.ownerSSN = ownerSSN;
		this.cardNumber = cardNumber;
		this.accountNum = accountNum;
		this.accountCreationDate = accountCreationDate;
	}

	public String getOwnerSSN() {
		return ownerSSN;
	}

	public void setOwnerSSN(String ownerSSN) {
		this.ownerSSN = ownerSSN;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public String getAccountCreationDate(){
		return accountCreationDate;
	}

	public void setAccountCreationDate(String accountCreationDate){
		this.accountCreationDate = accountCreationDate;
	}
	
	
}
