
public class Address{
	
	// person who is associated with the address
	Customer customer;
	
	private String street;
	private String city;
	private String state;
	private int zipcode;
	
	public Customer getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	public void setStreet(String street)
	{
		this.street = street;
	}
	public String getStreet()
	{
		return this.street;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getCity()
	{
		return this.city;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	public String getState()
	{
		return this.state;
	}
	public void setZipcode(int zipcode)
	{
		this.zipcode = zipcode;
	}
	public int getZipcode()
	{
		return this.zipcode;
	}
	
	public void printAddress()
	{
		System.out.print("Customer Address: " + street + " " + city + ", " + state + " "+zipcode + "\n");
	}

}
