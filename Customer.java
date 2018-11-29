package com.allisonrodenbaugh.springboothelloworld;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Functionality for Bank Customers</h1>
 * The Customer class implements the functionality that bank customers
 * can chose through the controller's UI.
 * <p>
 * <b>Note:</b> This class does not take user input directly but simply performs
 *  calculations/procedures that the user selected through the UI controller.
 *
 * @author  Allison Rodenbaugh
 * @version 1.0
 * @since   Fall 2018
 */
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
    }

    // Getters and Setters
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

    /**
     * Adds a new account to the system.
     * @param balance the initial balance of the account.
     *                  This will be a float number.
     * @param accountType the type of the account.
     *                    This will be Checking or Savings
     * @return Account object that was created
     */
    public Account addAccount(float balance, int accountType)
    {
        final Account account;
        if(accountType == 1) {
            account = new CheckingAccount(this.customerID);
        }
        else{
            account = new SavingsAccount(this.customerID);
        }
        account.setBalance(balance);
        printAccountConfirmation(account);
        return account;
    }

    /**
     * Adds a new account to the system.
     * @param loanAmount the initial balance of the account.
     *                  This will be a float number.
     * @param loanType the type of the loan.
     *                 This will be student, personal, auto, or business.
     * @return the loan object that was created
     */
    public Loan addLoan(float loanAmount, String loanType)
    {
        Loan loan = new Loan(this.customerID, loanType);
        loan.setLoanAmount(loanAmount);
        printLoanConfirmation(loan);
        return loan;
    }
    /**
     * Prints the Customer attributes for user to view.
     */
    public void printCustomer()
    {
        System.out.println("Customer Name: "+ customerName);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer Phone: " + phoneNo);
        address.printAddress();
    }

    /**
     * Prints the Account attributes for user to view.
     * This is displayed after adding new account.
     * @param account the account object to print confirmation for.
     */
    public void printAccountConfirmation(Account account)
    {
        System.out.println("Account added: ");
        account.printAccountDetails();
    }

    /**
     * Prints the laon attributes for user to view.
     * This is displayed after adding new loan.
     * @param loan the loan object to print confirmation for.
     */
    public void printLoanConfirmation(Loan loan)
    {
        System.out.println("Loan added:");
        loan.printLoanDetails();
    }

}