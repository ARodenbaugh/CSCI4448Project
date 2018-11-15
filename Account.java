package com.allisonrodenbaugh.springboothelloworld;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Account {

    private int accountID;
    private int customerID;
    private float balance;
    protected String accountType;

    public abstract float withdraw(float amount);

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
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public String getAccountType()
    {
        return accountType;
    }


}