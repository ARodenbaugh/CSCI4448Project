package com.allisonrodenbaugh.springboothelloworld;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadLocalRandom;

public class Loan {

    private int loanID;
    private int customerID;
    private double interestRate;
    private double loanAmount;

    public Loan(int customerID)
    {
        this.customerID = customerID;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
        this.loanID = randomNum; //testing purposes
    }
    public int getLoanID()
    {
        return this.loanID;
    }
    public int getCustomerID()
    {
        return this.customerID;
    }
    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }
    public double getInterestRate()
    {
        return this.interestRate;
    }
    public void setLoanAmount(double loanAmount)
    {
        this.loanAmount = loanAmount;
    }
    public double getLoanAmount()
    {
        return this.loanAmount;
    }
    public void applyInterestRates()
    {
        loanAmount = loanAmount * interestRate;
    }

}