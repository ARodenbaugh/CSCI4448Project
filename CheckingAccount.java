package com.allisonrodenbaugh.springboothelloworld;
public class CheckingAccount extends Account{


    public CheckingAccount(int customerID) {
        super(customerID);

    }
    @Override
    public void setAccountType(String accountType)
    {
        super.accountType = accountType;
    }

    public float withdraw(float amount)
    {
        float oldBalance = getBalance();
        float newBalance = oldBalance - amount;
        return newBalance;
    }
}
