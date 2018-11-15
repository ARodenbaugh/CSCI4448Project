package com.allisonrodenbaugh.springboothelloworld;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public static void loadDefaultData(BankAdmin admin)
    {
        // Add some customers
        Customer custOne = new Customer("John Doe");
        Customer custTwo = new Customer("Jack Reaper");
        Customer custThree = new Customer("Alice Shwab");
        Customer custFour = new Customer("Megan Turtle");

        // Add accounts to customers
        Account acctOne = new SavingsAccount(custOne.getCustomerID());
        Account acctTwo = new SavingsAccount(custTwo.getCustomerID());
        Account acctThree = new CheckingAccount(custThree.getCustomerID());
        Account acctFour = new CheckingAccount(custFour.getCustomerID());

        // Set balance of default accounts
        acctOne.setBalance(100);
        acctTwo.setBalance(200);
        acctThree.setBalance(300);
        acctFour.setBalance(400);

        // Create default customerlist
        admin.addToCustomerList(custOne);
        admin.addToCustomerList(custTwo);
        admin.addToCustomerList(custThree);
        admin.addToCustomerList(custFour);

        // Create default accountlist
        admin.addToAccountList(acctOne);
        admin.addToAccountList(acctTwo);
        admin.addToAccountList(acctThree);
        admin.addToAccountList(acctFour);
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


    public static void customerActions(BankAdmin admin)
    {
        // Display customer menu
        System.out.println("Select a Customer Action:");
        System.out.println("1. Made deposit");
        System.out.println("2. Make withdrawal");
        System.out.println("3. Make transfer");
        System.out.println("4. Make loan payment");
        System.out.println("5. View account balances");

        int action = getIntInput();
        switch(action) {
            case 1:
                System.out.println("deposit chosen");
                break;
            case 2:
                System.out.println("withdrawal chosen");
                break;
            case 3:
                System.out.println("transfer chosen");
                break;
            //etc.
            // View account balances
            case 5:
                System.out.println("Enter CustomerID for the checking account: ");
                int custID = getIntInput();
                admin.printCustomerAccounts(custID);
                break;
            default:
                System.out.println("Invalid action.");
                break;
        }
    }

    public static void adminActions(BankAdmin admin)
    {
        System.out.println("Select a Bank Admin action: ");
        System.out.println("1. Add a new customer");
        System.out.println("2. Add account to existing customer");
        System.out.println("3. Remove account from existing customer");
        System.out.println("4. Remove customer from system");
        System.out.println("5. Add loan to existing customer");
        System.out.println("6. View an accounts details");
        System.out.println("7. View a loans details");
        System.out.println("8. Apply interest rates to an account");

        // Get user input
        int action = getIntInput();
        switch(action) {
            // Add new customer
            case 1:
                admin.addNewCustomer();
                break;

            // Add account to customer
            case 2:
                System.out.println("Select Checking or Savings: ");
                System.out.println("1. Add Checking Account");
                System.out.println("2. Add Savings Account");
                int choice = getIntInput();
                switch(choice) {
                    case 1:
                        System.out.println("Enter CustomerID for the checking account: ");
                        int custID = getIntInput();
                        System.out.println("Enter balance for the checking account: ");
                        float balance = getIntInput();
                        admin.addCheckingAccount(custID, balance);
                        break;
                    case 2:
                        System.out.println("Enter CustomerID for the savings account: ");
                        int custID_2 = getIntInput();
                        System.out.println("Enter balance for the savings account: ");
                        float balance_2 = getIntInput();
                        admin.addSavingsAccount(custID_2, balance_2);
                        break;
                    default:
                        System.out.println("invalid input");
                        break;
                }
                break;

            // Remove account from existing customer
            case 3:
                System.out.println("Enter AccountID to be removed: ");
                int acctID = getIntInput();
                admin.removeAccount(acctID);
                break;

            // Remove existing customer from system
            case 4:
                System.out.println("Enter CustomerID to be removed: ");
                int custID_3 = getIntInput();
                admin.removeCustomer(custID_3);
                break;

            // Add loan to existing customer
            case 5:
                System.out.println("Enter a CustomerID for the loan: ");
                int custID_4 = getIntInput();
                System.out.println("Enter a loan amount: ");
                int loanAmount = getIntInput();
                admin.addLoan(custID_4, loanAmount);
                break;


            // Show account details
            case 6:
                System.out.println("Enter an AccountID: ");
                int accountID = getIntInput();
                admin.printAccountDetails(accountID);
                break;

            // Show loan details
            case 7:
                System.out.println("Enter a LoanID: ");
                int loanID = getIntInput();
                admin.printLoanDetails(loanID);
                break;

            // Apply interest rates
            case 8:
                System.out.println("Enter a LoanID: ");
                int loanID2 = getIntInput();
                Loan loan = admin.findLoan(loanID2);
                loan.applyInterestRates();
                admin.printLoanDetails(loanID2);
                break;

            //etc.
            default:
                System.out.println("Invalid action.");
                break;
        }

    }

    public static void main(String args[])
    {
        // Load the default customers and accounts
        BankAdmin admin = new BankAdmin();
        loadDefaultData(admin);

        // Boolean to loop through menu
        boolean shouldContinue = true;

        while(shouldContinue)
        {
            // Prompt for user
            System.out.println("\nSelect a User:\n 1. Bank Admin\n 2. Bank Customer \n 3. Quit");
            int choice = getIntInput();
            switch(choice) {
                case 1:
                    // Display admin prompts
                    adminActions(admin);
                    break;
                case 2:
                    // Display customer prompts
                    customerActions(admin);
                    break;
                case 3:
                    // Exit program
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.\n");
                    break;
            }
        }
        // User chose to exit program
        System.out.println("Goodbye.");
        System.exit(0);
    }

}