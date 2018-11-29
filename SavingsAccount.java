package com.allisonrodenbaugh.springboothelloworld;
/**
 * <h1>Functionality for Savings Account</h1>
 * The SavingsAccount class implements functionality for manipulating data
 * (specifically making withdrawals) from saving accounts
 * <p>
 * <b>Note:</b> This class further implements the Template method by overriding
 * several functions from its Account parent class.
 *
 * @author  Allison Rodenbaugh
 * @version 1.0
 * @since   Fall 2018
 */
public class SavingsAccount extends Account {

    public SavingsAccount(int customerID) {
        super(customerID);
        super.accountType = "Savings";

    }
    /**
     * Notifies user of how account withdrawals work differently for
     * the Savings account type.
     */
    @Override
    public void notifyWithdrawal()
    {
        System.out.println("WARNING: Savings Account balances cannot become negative. Your current savings account details:");
        printAccountDetails();
    }

    /**
     * Withdraw money from an account.
     * @param amount the dollar amount for the withdrawal.
     * @param balanceCompare the boolean for if current balance
     *                       is greater than withdrawal amount.
     */
    @Override
    public void withdraw(int amount, boolean balanceCompare)
    {
        if(balanceCompare)
        {
            float oldBalance = getBalance();
            float newBalance = oldBalance - amount;
            this.setBalance(newBalance);
            System.out.println("SUCCESS!");
        }
        else{
            System.out.println("WITHDRAWAL CANCELLED. Insufficient funds. Savings account balances cannot become negative.");
        }
        System.out.println("Your account details:");
        printAccountDetails();
    }



}