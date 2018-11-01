import java.util.ArrayList;
import java.util.Scanner;

public class BankAdmin {

	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Account> accountList = new ArrayList<Account>();
	private float currentLoanRate;
	
	public void addToCustomerList(Customer customer) 
	{
		customerList.add(customer);
	}
	public ArrayList<Customer> getCustomerList()
	{
		return customerList;
	}
	public void addToAccountList(Account account) 
	{
		accountList.add(account);
	}
	public ArrayList<Account> getAccountList()
	{
		return accountList;
	}
	public void setCurrentLoanRate(float currentLoanRate)
	{
		this.currentLoanRate = currentLoanRate;
	}
	public float getCurrentLoanRate()
	{
		return currentLoanRate;
	}
	public static int getIntInput()
	{
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	public static String getStringInput()
	{
		Scanner input = new Scanner(System.in);
		String user_input = input.nextLine();
		//input.close();
		return user_input;
	}
	
	public void addNewCustomer() 
	{
		// Create customer object
		System.out.println("Enter Customer name: ");
		String name = getStringInput();
		Customer newCust = new Customer(name);
		
		// Add customer information to object
		System.out.println("Enter Customer phone number: ");
		newCust.setPhoneNo(getStringInput());
		
		System.out.println("Enter Address street: ");
		newCust.address.setStreet(getStringInput());
		
		System.out.println("Enter Address city: ");
		newCust.address.setCity(getStringInput());
		
		System.out.println("Enter Address state: ");
		newCust.address.setState(getStringInput());
		
		System.out.println("Enter Address zipcode: ");
		newCust.address.setZipcode(getIntInput());
		
		//Add new customer to customerList
		this.addToCustomerList(newCust);
		
		newCust.printCustomer(); //testing purposes
	}
	
	public void printAccountDetails(int accountID)
	{
		for(Account account : accountList) {
			if(account.getAccountID() == accountID)
			{
				System.out.println("AccountID: " + account.getAccountID());
				System.out.println("Account owner: " + account.getCustomerID());
				System.out.println("Account balance: " + account.getBalance());
			}
		}
	}
	
	public void addAccount(int customerID, float balance)
	{
		for(Customer customer : customerList) 
		{
			if(customer.getCustomerID() == customerID)
			{
				customer.addAccount(balance);
			}
		}
	}
}
