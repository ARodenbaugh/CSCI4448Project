package com.allisonrodenbaugh.springboothelloworld;
/**
 * <h1>Class for storing address information of a customer</h1>
 * The Address class is used for adding new customers to the system.
 * Their address will be included as part of their profile.
 * <p>
 * <b>Note:</b> This class does not take user input directly but simply
 * inserts data into fields and prints out field information. This class
 * is used for organizing customer information.
 *
 * @author  Allison Rodenbaugh
 * @version 1.0
 * @since   Fall 2018
 */
public class Address{

    private String street;
    private String city;
    private String state;
    private int zipcode;

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

    /**
     * Prints the Address attributes for user to view
     * with customer information.
     */
    public void printAddress()
    {
        System.out.print("Customer Address: " + street + " " + city + ", " + state + " "+zipcode + "\n");
    }

}