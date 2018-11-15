package com.allisonrodenbaugh.springboothelloworld;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BankAdmin {

    ArrayList<Customer> customerList = new ArrayList<Customer>();
    ArrayList<Account> accountList = new ArrayList<Account>();
    ArrayList<Loan> loanList = new ArrayList<Loan>();
    private float currentLoanRate;

    public void addToCustomerList(Customer customer)
    {
        customerList.add(customer);
    }
    public void addToLoanList(Loan loan)
    {
        loanList.add(loan);
    }
    public ArrayList<Customer> getCustomerList()
    {
        return customerList;
    }
    public void addToAccountList(Account account)
    {
        accountList.add(account);
    }
    public ArrayList<Account> getAccountList()
    {
        return accountList;
    }
    public void setCurrentLoanRate(float currentLoanRate)
    {
        this.currentLoanRate = currentLoanRate;
    }
    public float getCurrentLoanRate()
    {
        return currentLoanRate;
    }
    public static int getIntInput()
    {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static String getStringInput()
    {
        Scanner input = new Scanner(System.in);
        String user_input = input.nextLine();
        //input.close();
        return user_input;
    }
    public String getCustomerName(int customerID)
    {
        String name = "";
        for(Customer customer : customerList) {
            if(customer.getCustomerID() == customerID)
            { name = customer.getName();}
            else { name = "Customer does not exist";}
        }return name;
    }

    public void addNewCustomer()
    {
        // Create customer object
        System.out.println("Enter Customer name: ");
        String name = getStringInput();
        Customer newCust = new Customer(name);

        // Add customer information to object
        System.out.println("Enter Customer phone number: ");
        newCust.setPhoneNo(getStringInput());

        System.out.println("Enter Address street: ");
        newCust.address.setStreet(getStringInput());

        System.out.println("Enter Address city: ");
        newCust.address.setCity(getStringInput());

        System.out.println("Enter Address state: ");
        newCust.address.setState(getStringInput());

        System.out.println("Enter Address zipcode: ");
        newCust.address.setZipcode(getIntInput());

        //Add new customer to customerList
        this.addToCustomerList(newCust);

        newCust.printCustomer(); //testing purposes
    }

    public void printAccountDetails(int accountID)
    {
        for(Account account : accountList)
        {
            if(account.getAccountID() == accountID)
            {
                System.out.println("AccountID: " + account.getAccountID());
                System.out.println("Account type: " + account.getAccountType());
                System.out.println("Account owner: " + getCustomerName(account.getCustomerID()));
                System.out.println("Account balance: " + account.getBalance());
            }
        }
    }
    public void printLoanDetails(int loanID)
    {
        for(Loan loan : loanList)
        {
            if(loan.getLoanID() == loanID)
            {
                System.out.println("LoanID: " + loan.getLoanID());
                System.out.println("Loan owner: " + getCustomerName(loan.getCustomerID()));
                System.out.println("Loan amount: " + loan.getLoanAmount());
                System.out.println("Loan interest rate: " + loan.getInterestRate());
            }
        }
    }

    public void addSavingsAccount(int customerID, float balance)
    {
        for(Customer customer : customerList)
        {
            if(customer.getCustomerID() == customerID)
            {
                SavingsAccount account = customer.addSavingsAccount(balance); //returns account
                addToAccountList(account);
            }
        }
    }
    public void addCheckingAccount(int customerID, float balance)
    {
        for(Customer customer : customerList)
        {
            if(customer.getCustomerID() == customerID)
            {
                CheckingAccount account = customer.addCheckingAccount(balance); //returns account
                addToAccountList(account);
            }
        }
    }
    public void addLoan(int customerID, float loanAmount)
    {
        for(Customer customer : customerList)
        {
            if(customer.getCustomerID() == customerID)
            {
                Loan loan = customer.addLoan(loanAmount); //returns account
                loan.setInterestRate(1.09); // for testing purposes
                addToLoanList(loan);
            }
        }
    }
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

    public void printCustomerAccounts(int customerID)
    {
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
            printAccountDetails(accountToPrint.getAccountID());
        }
    }

    public void removeAccount(int accountID)
    {
        Account account = findAccount(accountID);
        if(account != null)
        {
            accountList.remove(account);
            System.out.println("Account with ID '" + accountID + "' has been removed.");
        }
        else
        {
            System.out.println("Account with ID '" + accountID + "' does not exist");
        }
    }
    public void removeCustomer(int customerID)
    {
        // Loop through customer list to remove customer
        for(Iterator<Customer> iterator = customerList.iterator(); iterator.hasNext(); ) {
            Customer current = iterator.next();
            if(current.getCustomerID() == customerID)
            {
                iterator.remove();
                System.out.println("Customer with ID '" + current.getCustomerID() + "' has been removed.");
            }
        }
        // remove existing accounts the customer may have
        for(Iterator<Account> iterator2 = accountList.iterator(); iterator2.hasNext(); ) {
            Account current2 = iterator2.next();
            if(current2.getCustomerID() == customerID)
            {
                System.out.println("Corresponding account with ID '" + current2.getAccountID() + "' has been removed.");
                iterator2.remove();
            }
        }
        // remove existing loan accounts the customer may have
        for(Iterator<Loan> iterator3 = loanList.iterator(); iterator3.hasNext(); ) {
            Loan current3 = iterator3.next();
            if(current3.getCustomerID() == customerID)
            {
                System.out.println("Corresponding loan with ID '" + current3.getLoanID() + "' has been removed.");
                iterator3.remove();
            }
        }
    }
}