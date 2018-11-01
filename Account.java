import java.util.concurrent.ThreadLocalRandom;

public class Account {
	
	private int accountID;
	private int customerID;
	private float balance;
	
	// Constructor for Account class
	public Account(int customerID)
	{
		this.customerID = customerID;
		int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		this.accountID = randomNum; //testing purposes
		System.out.println("Account generated. AccountID: " + this.accountID); //testing purposes
	}
	
	public void setAccountID(int accountID)
	{
		this.accountID = accountID;
	}
	public int getAccountID() 
	{
		return this.accountID;
	}
	
	public void setCustomerID(int customerID)
	{
		this.customerID = customerID;
	}
	public int getCustomerID()
	{
		return this.customerID;
	}
	public void setBalance(float balance)
	{
		this.balance = balance;
	}
	public float getBalance()
	{
		return balance;
	}
	public void printAccountDetails()
	{
		System.out.println("Account owner: " + customerID);
		System.out.println("AccountID: " + accountID);
		System.out.println("Account Balance: " + balance);
	}

}
