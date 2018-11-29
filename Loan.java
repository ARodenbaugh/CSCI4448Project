package com.allisonrodenbaugh.springboothelloworld;
import java.util.concurrent.ThreadLocalRandom;
/**
 * <h1>Functionality for Loans</h1>
 * The Loan class implements functionality for manipulating data
 * (specifically adjusting loan balance through deposits/applying interest rates)
 *<p>
 * @author  Allison Rodenbaugh
 * @version 1.0
 * @since   Fall 2018
 */
public class Loan {

    private int loanID;
    private int customerID;
    private String loanType;
    private double interestRate;
    private double loanAmount;

    public Loan(int customerID, String loanType) {
        this.customerID = customerID;
        this.loanType = loanType;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);
        this.loanID = randomNum;
    }

    public int getLoanID() {
        return this.loanID;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanType() {
        return this.loanType;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getLoanAmount() {
        return this.loanAmount;
    }

    /**
     * Make a loan payment. Decreases loan amount by user payment amount.
     * @param payment the dollar amount for the loan payment.
     */
    public void makePayment(double payment) {
        this.loanAmount = this.loanAmount - payment;
    }

    /**
     * Print the details of a loan for confirmation/viewing purposes.
     */
    public void printLoanDetails() {
        System.out.println("LoanID: " + getLoanID());
        System.out.println("Loan Type: " + getLoanType());
        System.out.println("Loan OwnerID: " + getCustomerID());
        System.out.println("Loan Balance: " + getLoanAmount());
        System.out.println("Loan Interest Rate: " + getInterestRate());
    }

    /**
     * Apply interest rates to a loan. Will multiply the loan amount
     * by the interest rate. Used for annual interest applications.
     */
    public void applyInterestRate() {
        loanAmount = loanAmount * interestRate;
    }
}