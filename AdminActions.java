package com.allisonrodenbaugh.springboothelloworld;
/**
 * <h1>Functionality for Admin Action Controller</h1>
 * The AdminActions class displays actions the bank admin can take
 * and gathers input from said user.
 * <p>
 * <b>Note:</b> This class extends the main controller class
 *
 * @author  Allison Rodenbaugh
 * @version 1.0
 * @since   Fall 2018
 */
public class AdminActions extends Controller {

    /**
     * Processes the user-selected acitons for a bank admin user.
     * @param admin The BankAdmin object used for manipulating data.
     */
    public void processActions(BankAdmin admin)
    {
        System.out.println("Select a Bank Admin action: ");
        System.out.println("1. Add a new customer");
        System.out.println("2. Add account to existing customer");
        System.out.println("3. Remove account from existing customer");
        System.out.println("4. Remove customer from system");
        System.out.println("5. Add loan to existing customer");
        System.out.println("6. View an accounts details");
        System.out.println("7. View a loans details");
        System.out.println("8. Apply interest rates to a loan account");

        // Get user input
        int action = getIntInput();
        switch(action) {
            // Add new customer
            case 1:
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
                admin.addToCustomerList(newCust);

                // Print out customer confirmation
                newCust.printCustomer();

                break;

            // Add account to customer
            case 2:
                System.out.println("Select Checking or Savings: ");
                System.out.println("1. Add Checking Account");
                System.out.println("2. Add Savings Account");
                int accountType = getIntInput();
                switch(accountType) {
                    case 1:
                        System.out.println("Enter CustomerID for the checking account: ");
                        int custID = getIntInput();
                        Customer cust = admin.findCustomer(custID);
                        if(cust != null) {
                            System.out.println("Enter balance for the checking account: ");
                            float balance = getIntInput();
                            admin.addAccountToCustomer(cust, balance, accountType);
                        }
                        else{invalidCustomer(custID);}
                        break;
                    case 2:
                        System.out.println("Enter CustomerID for the savings account: ");
                        int custID_2 = getIntInput();
                        Customer cust2 = admin.findCustomer(custID_2);
                        if(cust2 != null) {
                            System.out.println("Enter balance for the savings account: ");
                            float balance_2 = getIntInput();
                            admin.addAccountToCustomer(cust2, balance_2, accountType);
                        }
                        else{invalidCustomer(custID_2);}
                        break;
                    default:
                        System.out.println("invalid input");
                        break;
                }
                break;

            // Remove account from existing customer
            case 3:
                System.out.println("Enter AccountID to be removed: ");
                int accID = getIntInput();
                Account account3 = admin.findAccount(accID);
                if (account3 != null) {
                    admin.removeAccount(account3);
                    System.out.println("Account with ID '" + account3.getAccountID() + "' has been removed.");
                }
                else{
                    invalidAccount(accID);
                }
                break;

            // Remove existing customer from system
            case 4:
                System.out.println("Enter CustomerID to be removed: ");
                int custID_3 = getIntInput();
                Customer customer = admin.findCustomer(custID_3);
                if(customer != null) {
                    admin.removeCustomer(customer);
                }
                else{
                    invalidCustomer(custID_3);
                }
                break;

            // Add loan to existing customer
            case 5:
                System.out.println("Enter a CustomerID for the loan: ");
                int custID_4 = getIntInput();
                Customer customer2 = admin.findCustomer(custID_4);
                if(customer2 != null) {
                    System.out.println("Enter a loan amount: ");
                    int loanAmount = getIntInput();
                    System.out.println("Enter loan type: \nValid loan types include: Student, Auto, Business or Personal.");
                    String loanType = getStringInput();
                    if (loanType.equals("Student") || loanType.equals("Auto") || loanType.equals("Business") || loanType.equals("Personal")) {
                        admin.addLoanToCustomer(customer2, loanAmount, loanType);
                    } else {
                        System.out.println("Loan type invalid.");
                    }
                }
                else{
                    invalidCustomer(custID_4);
                }
                break;


            // Show account details
            case 6:

                System.out.println("Enter an AccountID: ");
                int accountID = getIntInput();
                Account account = admin.findAccount(accountID);
                if(account != null) {
                    account.printAccountDetails();
                }
                else{
                    invalidAccount(accountID);
                }
                break;

            // Show loan details
            case 7:
                System.out.println("Enter a LoanID: ");
                int loanID = getIntInput();
                Loan loan = admin.findLoan(loanID);
                if(loan != null) {
                    loan.printLoanDetails();
                }
                else{
                    invalidLoan(loanID);
                }
                break;

            // Apply interest rates
            case 8:
                System.out.println("Enter a LoanID: ");
                int loanID2 = getIntInput();
                Loan loan2 = admin.findLoan(loanID2);
                if(loan2 != null) {
                    loan2.applyInterestRate();
                    loan2.printLoanDetails();

                }
                else{
                    invalidLoan(loanID2);
                }
                break;

            //etc.
            default:
                System.out.println("Invalid action.");
                break;
        }

    }
}