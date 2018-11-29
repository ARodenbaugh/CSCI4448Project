package com.allisonrodenbaugh.springboothelloworld;
/**
 * <h1>Functionality for Checking Account</h1>
 * The CheckingAccount class implements functionality for manipulating data
 * (specifically making withdrawals) from checking accounts
 * <p>
 * <b>Note:</b> This class further implements the Template method by overriding
 * several functions from its Account parent class.
 *
 * @author  Allison Rodenbaugh
 * @version 1.0
 * @since   Fall 2018
 */
public class CheckingAccount extends Account{


    public CheckingAccount(int customerID) {
        super(customerID);
        super.accountType = "Checking";

    }

    /**
     * Notifies user of how account withdrawals work differently for
     * the checking acocunt type.
     */
    @Override
    public void notifyWithdrawal()
    {
        System.out.println("NOTICE: Checking account balances CAN become negative. Your current checking account details:");
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
        float oldBalance = getBalance();
        float newBalance = oldBalance - amount;
        this.setBalance(newBalance);
        System.out.println("SUCCESS!");
        if(!balanceCompare){
            System.out.println("NOTICE: Checking account balance is now negative.");
        }
        System.out.println("Your account details:");
        printAccountDetails();
    }



}