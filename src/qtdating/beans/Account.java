package qtdating.beans;

public class Account {
	
	private String ownerSSN;
	private int cardNumber;
	private String accountNum;
	
	public Account() {
		
	}

	public Account(String ownerSSN, int cardNumber, String accountNum) {
		this.ownerSSN = ownerSSN;
		this.cardNumber = cardNumber;
		this.accountNum = accountNum;
	}

	public String getOwnerSSN() {
		return ownerSSN;
	}

	public void setOwnerSSN(String ownerSSN) {
		this.ownerSSN = ownerSSN;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	
}
