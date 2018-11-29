package com.allisonrodenbaugh.springboothelloworld;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <h1>Functionality for Bank Administrators</h1>
 * The BankAdmin class implements the functionality that bank admin
 * select through the controller's UI.
 * <p>
 * <b>Note:</b> This class does not take user input directly but simply performs
 *  calculations/procedures that the user chose through the UI controller.
 *
 * @author  Allison Rodenbaugh
 * @version 1.0
 * @since   Fall 2018
 */
public class BankAdmin {

    ArrayList<Customer> customerList = new ArrayList<Customer>();
    ArrayList<Account> accountList = new ArrayList<Account>();
    ArrayList<Loan> loanList = new ArrayList<Loan>();
    private float currentLoanRate;

    /**
     * Adds Customer object to Customer ArrayList.
     * @param customer the customer Object to add to the list.
     */
    public void addToCustomerList(Customer customer)
    {
        customerList.add(customer);
    }
    /**
     * Adds Loan object to loan ArrayList.
     * @param loan The loan Object to add to the list.
     */
    public void addToLoanList(Loan loan) { loanList.add(loan); }
    /**
     * Adds account object to account ArrayList.
     * @param account The account Object to add to the list.
     */
    public void addToAccountList(Account account)
    {
        accountList.add(account);
    }

    /**
     * Retrieves name of customer using their ID.
     * Used for Confirmation/display purposes.
     * @param customerID the customerID for the Customer object
     * @return String depicting if customer exists in system.
     *
     */
    public String getCustomerName(int customerID)
    {
        String name;
        Customer customer = findCustomer(customerID);
        if(customer != null)
        {
            name = customer.getName();
        }
        else
        {
            name = "Customer does not exist";
        }
        return name;
    }

    /**
     * Creates new account and adds to customer.
     * @param customer the customer Object to add an account to.
     * @param balance the initial balance of the account.
     * @param accountType the type of the account - checking/savings.
     */
    public void addAccountToCustomer(Customer customer, float balance, int accountType)
    {
        Account account = customer.addAccount(balance, accountType); //returns account
        addToAccountList(account);
    }
    /**
     * Creates new account and adds to customer.
     * @param customer the customer Object to add a loan to.
     * @param loanAmount the initial amount of the loan.
     * @param loanType the type of the loan.
     */
    public void addLoanToCustomer(Customer customer, float loanAmount, String loanType)
    {
        Loan loan = customer.addLoan(loanAmount, loanType); //returns loan
        loan.setInterestRate(1.09); // for testing purposes
        addToLoanList(loan);

    }
    /**
     * Finds and returns a loan object given a loan ID.
     * @param loanID the id of the Loan to search for.
     * @return the loan object with the loanID.
     */
    public Loan findLoan(int loanID)
    {
        for(Iterator<Loan> iterator = loanList.iterator(); iterator.hasNext(); ) {
            Loan loan = iterator.next();
            if(loan.getLoanID() == loanID)
            {
                return loan;
            }
        }
        return null;
    }
    /**
     * Finds and returns an account object given an account ID.
     * @param accountID the id of the account to search for.
     * @return the account object with the accountID.
     */
    public Account findAccount(int accountID)
    {
        for(Iterator<Account> iterator = accountList.iterator(); iterator.hasNext(); ) {
            Account account = iterator.next();
            if(account.getAccountID() == accountID)
            {
                return account;
            }
        }
        return null;
    }
    /**
     * Finds and returns a customer object given a customer ID.
     * @param customerID the id of the Customer to search for.
     * @return the customer object with the customerID.
     */
    public Customer findCustomer(int customerID)
    {
        for(Iterator<Customer> iterator = customerList.iterator(); iterator.hasNext(); ) {
            Customer customer = iterator.next();
            if(customer.getCustomerID() == customerID)
            {
                return customer;
            }
        }
        return null;
    }
    /**
     * Removes an account from the system.
     * @param account the account object to remove from the system.
     */
    public void removeAccount(Account account) {
        accountList.remove(account);

    }
    /**
     * Removes a loan from the system.
     * @param loan the loan object to remove from the system.
     */
    public void removeLoan(Loan loan){
        loanList.remove(loan);
    }

    /**
     * Removes a customer from the system.
     * Also will remove corresponding accounts/loans for the customer.
     * @param customer the customer object to remove from the system.
     */
    public void removeCustomer(Customer customer)
    {
        customerList.remove(customer);
        System.out.println("Customer " + customer.getName() + "with ID '" + customer.getCustomerID() + "' has been removed.");

        // remove existing accounts the customer may have
        ArrayList<Account> toRemove = new ArrayList<>();
        for(Iterator<Account> iterator2 = accountList.iterator(); iterator2.hasNext(); ) {
            Account current2 = iterator2.next();
            if(current2.getCustomerID() == customer.getCustomerID())
            {
                System.out.println("Corresponding account with ID '" + current2.getAccountID() + "' has been removed.");
                toRemove.add(current2);
            }
        }
        for (Account acc: toRemove)
        {
            removeAccount(acc);
        }

        // remove existing loan accounts the customer may have
        ArrayList<Loan> willRemove = new ArrayList<>();
        for(Iterator<Loan> iterator3 = loanList.iterator(); iterator3.hasNext(); ) {
            Loan current3 = iterator3.next();
            if(current3.getCustomerID() == customer.getCustomerID())
            {
                System.out.println("Corresponding loan with ID '" + current3.getLoanID() + "' has been removed.");
                willRemove.add(current3);
            }
        }
        for (Loan loan: willRemove)
        {
            removeLoan(loan);
        }
    }
    /**
     * Print out all of the accounts corresponding to a customer.
     * @param  customerID the customer ID corresponding to the accounts.
     */
    public void printCustomerAccounts(int customerID)
    {
        String custName = getCustomerName(customerID);
        ArrayList<Account> customerAccounts = new ArrayList<Account>();
        for(Iterator<Account> iterator = accountList.iterator(); iterator.hasNext(); ) {
            Account account = iterator.next();
            if(account.getCustomerID() == customerID)
            {
                customerAccounts.add(account);
            }
        }
        Iterator<Account> iter = customerAccounts.iterator();
        while (iter.hasNext()) {
            Account accountToPrint = iter.next();
            System.out.println("Account owner: " + custName);
            accountToPrint.printAccountDetails();
        }
    }

}