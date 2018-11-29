package com.allisonrodenbaugh.springboothelloworld;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

/**
 * <h1>Functionality for Account</h1>
 * The Account class implements the functionality for manipulating account data
 * <p>
 * <b>Note:</b> This class does implements the Template Method to perform
 * withdrawals for the different Account types depicted in it's subclasses.
 *
 * @author  Allison Rodenbaugh
 * @version 1.0
 * @since   Fall 2018
 */
public abstract class Account {

    private int accountID;
    private int customerID;
    private float balance;
    protected String accountType;

    // Constructor for Account class
    public Account(int customerID)
    {
        this.customerID = customerID;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);
        this.accountID = randomNum; //testing purposes
    }

    /**
     * Notifies user of how account withdrawals work differently for
     * the different account types.
     */
    abstract void notifyWithdrawal();

    /**
     * Withdraw money from an account.
     * @param amount the dollar amount for the withdrawal.
     * @param balanceCompare the boolean for if current balance
     *                       is greater than withdrawal amount.
     */
    abstract void withdraw(int amount, boolean balanceCompare);

    /**
     * Template Method to perform a withdrawal on an account
     * Will treat checking and savings withdrawals differently
     */
    public final void makeWithdrawal(){

        // 1. ABSTRACT METHOD: Notify user of current account details
        notifyWithdrawal();

        // 2. Retrieve withdrawal amount
        int amount = getWithdrawalAmount();

        // 3. Compare withdrawal amount to balance of account
        boolean balanceCompare = checkBalanceValid(amount);

        // 4. ABSTRACT METHOD: Complete or deny withdrawal based on subclass algorithms
        withdraw(amount, balanceCompare);

    }
    /**
     * Retrieve the dollar amount to withdrawal from the account
     * @return the user inputted withdrawal amount
     */
    public int getWithdrawalAmount()
    {
        System.out.println("Enter withdrawal amount for account with ID '" + this.accountID + "':");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    /**
     * Checks if current balance can cover withdrawal request
     * @param amount The dollar amount the user wishes to withdraw.
     * @return boolean for if balance can cover withdrawal.
     */
    public boolean checkBalanceValid(int amount)
    {
        if (amount < this.getBalance()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Changes the name of this Student.
     * This may involve a lengthy legal process.
     * @param depositAmt The dollar amount to deposit.
     *                Will add to current balance.
     */
    public void makeDeposit(int depositAmt)
    {
        this.balance = this.balance + depositAmt;
    }

    /**
     * Prints out the account details
     */
    public void printAccountDetails()
    {
        System.out.println("AccountID: " + getAccountID());
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Account OwnerID: " + getCustomerID());
        System.out.println("Account Balance: " + getBalance());
    }

    /* ======= Getters and setters for Account class ========= */
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
    public String getAccountType()
    {
        return accountType;
    }


}