package com.allisonrodenbaugh.springboothelloworld;
import java.util.Iterator;
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
    // Add account with instantiated balance & Specify account type
    public SavingsAccount addSavingsAccount(float balance)
    {
        SavingsAccount account = new SavingsAccount(this.customerID);
        account.setBalance(balance);
        account.setAccountType("Savings");
        printAccountConfirmation(account);
        return account;
    }
    public CheckingAccount addCheckingAccount(float balance)
    {
        CheckingAccount account = new CheckingAccount(this.customerID);
        account.setBalance(balance);
        account.setAccountType("Checking");
        printAccountConfirmation(account);
        return account;
    }
    public Loan addLoan(float loanAmount)
    {
        Loan loan = new Loan(this.customerID);
        loan.setLoanAmount(loanAmount);
        printLoanConfirmation(loan);
        return loan;

    }

    public void printCustomer()
    {
        System.out.println("Customer Name: "+ customerName);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer Phone: " + phoneNo);
        address.printAddress();
    }

    // Remove after testing
    public void printAccountConfirmation(Account account)
    {
        System.out.println("Account added.\nAccountID: " + account.getAccountID());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Account OwnerID: " + account.getCustomerID());
        System.out.println("Account Balance: " + account.getBalance());
    }
    // Remove after testing
    public void printLoanConfirmation(Loan loan)
    {
        System.out.println("Loan added.\nLoanID: " + loan.getLoanID());
        System.out.println("Loan OwnerID: " + loan.getCustomerID());
        System.out.println("Loan Balance: " + loan.getLoanAmount());
        System.out.println("Loan Interest Rate: " + loan.getInterestRate());
    }

}