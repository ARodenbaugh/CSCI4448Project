package com.allisonrodenbaugh.springboothelloworld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

/**
 * <h1>Main Controller Class</h1>
 * The Controller class displays the roles for the user to select
 * and contains functions for gathering user input.
 * <p>
 * <b>Note:</b> This class acts as the main controller class.
 *              The application uses the Spring framework.
 *
 * @author  Allison Rodenbaugh
 * @version 1.0
 * @since   Fall 2018
 */
@SpringBootApplication
public class Controller {
    /**
     * Loads Default data into the system
     * @param admin The bank admin object.
     *              Keeps track of existing customers/accounts
     */
    public static void loadDefaultData(BankAdmin admin)
    {
        // Add some customers
        Customer custOne = new Customer("John Doe");
        System.out.println("Customer generated. ID: " + custOne.getCustomerID());
        //Customer custTwo = new Customer("Jack Reaper");
        //System.out.println("Customer generated. ID: " + custTwo.getCustomerID());
        //Customer custThree = new Customer("Alice Shwab");
        //System.out.println("Customer generated. ID: " + custThree.getCustomerID());
        //Customer custFour = new Customer("Megan Turtle");
        //System.out.println("Customer generated. ID: " + custFour.getCustomerID());

        // Add accounts to customers
        Account acctOne = new SavingsAccount(custOne.getCustomerID());
        System.out.println("account generated. ID: " + acctOne.getAccountID() + ". Type: " + acctOne.getAccountType());
        Account acctOne1 = new CheckingAccount(custOne.getCustomerID());
        System.out.println("account generated. ID: " + acctOne1.getAccountID() + ". Type: " + acctOne1.getAccountType());
        //Account acctTwo = new SavingsAccount(custTwo.getCustomerID());
        //System.out.println("account generated. ID: " + acctTwo.getAccountID() + ". Type: " + acctTwo.getAccountType());
        //Account acctTwo1 = new CheckingAccount(custTwo.getCustomerID());
        //System.out.println("account generated. ID: " + acctTwo1.getAccountID() + ". Type: " + acctTwo1.getAccountType());
        //Account acctThree = new SavingsAccount(custThree.getCustomerID());
        //System.out.println("account generated. ID: " + acctThree.getAccountID() + ". Type: " + acctThree.getAccountType());
       // Account acctThree1 = new CheckingAccount(custThree.getCustomerID());
        //System.out.println("account generated. ID: " + acctThree1.getAccountID() + ". Type: " + acctThree1.getAccountType());
        //Account acctFour = new SavingsAccount(custFour.getCustomerID());
        //System.out.println("account generated. ID: " + acctFour.getAccountID() + ". Type: " + acctFour.getAccountType());
        //Account acctFour1 = new CheckingAccount(custFour.getCustomerID());
        //System.out.println("account generated. ID: " + acctFour1.getAccountID() + ". Type: " + acctFour1.getAccountType());

        // Set balance of default accounts
        acctOne.setBalance(100);
        acctOne1.setBalance(101);
        //acctTwo.setBalance(200);
        //acctTwo1.setBalance(201);
        //acctThree.setBalance(300);
        //acctThree1.setBalance(301);
        //acctFour.setBalance(400);
        //acctFour1.setBalance(401);

        // Create default customerlist
        admin.addToCustomerList(custOne);
        //admin.addToCustomerList(custTwo);
        //admin.addToCustomerList(custThree);
        //admin.addToCustomerList(custFour);

        // Create default accountlist
        admin.addToAccountList(acctOne);
        //admin.addToAccountList(acctTwo);
        //admin.addToAccountList(acctThree);
        //admin.addToAccountList(acctFour);
        admin.addToAccountList(acctOne1);
        //admin.addToAccountList(acctTwo1);
        //admin.addToAccountList(acctThree1);
        //admin.addToAccountList(acctFour1);
    }

    /**
     * Gets an integer input from the user.
     * @return a user-inputted integer.
     */
    public static int getIntInput()
    {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    /**
     * Gets a String input from the user.
     * @return a user-inputted string.
     */
    public static String getStringInput()
    {
        Scanner input = new Scanner(System.in);
        String user_input = input.nextLine();
        //input.close();
        return user_input;
    }
    /**
     * Displays invalid Account IK error.
     * @param accountID The user-inputted ID for the account
     */
    public static void invalidAccount(int accountID)
    {
        System.out.println("Account with ID '" + accountID + "' does not exist.");
    }
    /**
     * Displays invalid Loan ID error.
     * @param loanID The user-inputted ID for the loan
     */
    public static void invalidLoan(int loanID)
    {
        System.out.println("Loan with ID '" + loanID + "' does not exist.");
    }
    /**
     * Displays invalid Customer ID error.
     * @param custID The user-inputted ID for the customer
     */
    public static void invalidCustomer(int custID)
    {
        System.out.println("Customer with ID '" + custID + "' does not exist.");
    }

    /**
     * The main method - launches the application.
     * Takes in user input to select a role.
     * @param args User input.
     */
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
                    AdminActions adminActions = new AdminActions();
                    adminActions.processActions(admin);
                    break;
                case 2:
                    // Display customer prompts
                    CustomerActions custActions = new CustomerActions();
                    custActions.processActions(admin);

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
