import java.util.concurrent.ThreadLocalRandom;
public class Customer {
	
	private int customerID;
	private String customerName;
	private String phoneNo;
	Address address = new Address();
	
	// Constructor for Customer class
	public Customer(String customerName)
	{
		this.customerName = customerName;
		int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		this.customerID = randomNum; //testing purposes
		System.out.println("Customer generated. ID: " + customerID); //testing purposes

	}
	
	public int getCustomerID()
	{
		return this.customerID;
	}
	
	public void setName(String name)
	{
		this.customerName = name;
	}
	public String getName()
	{
		return this.customerName;
	}
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}
	public String getPhoneNo()
	{
		return this.phoneNo;
	}
	
	public void setAddress(Address address)
	{
		this.address = address;
	}
	public Address getAddress()
	{
		return this.address;
	}
	// Add account with instantiated balance
	public void addAccount(float balance)
	{
		Account account = new Account(this.customerID);
		account.setBalance(balance);
		System.out.println("Account added.\nAccountID: " + account.getAccountID());
		System.out.println("Account OwnerID: " + account.getCustomerID());
		System.out.println("Account Balance: " + account.getBalance());
	}
	
	public void printCustomer()
	{
		System.out.println("Customer Name: "+ customerName);
		System.out.println("Customer ID: " + customerID);
		System.out.println("Customer Phone: " + phoneNo);
		address.printAddress();
	}

}
