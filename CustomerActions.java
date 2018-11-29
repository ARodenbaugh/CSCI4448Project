package com.allisonrodenbaugh.springboothelloworld;
/**
 * <h1>Functionality for Customer Action Controller</h1>
 * The CustomerActions class displays actions the bank customer can take
 * and gathers input from said user.
 * <p>
 * <b>Note:</b> This class extends the main controller class
 *
 * @author  Allison Rodenbaugh
 * @version 1.0
 * @since   Fall 2018
 */
public class CustomerActions extends Controller {
    /**
     * Processes the user-selected acitons for a customer user.
     * @param admin The BankAdmin object used for manipulating data.
     */
    public void processActions(BankAdmin admin)
    {
        // Retrieve customer ID and check validity
        System.out.println("Enter your Customer ID to view options: ");
        int custID = getIntInput();
        Customer customer = admin.findCustomer(custID);
        if (customer != null)
        {
            // Display customer menu
            System.out.println("Select a Customer Action:");
            System.out.println("1. Made deposit");
            System.out.println("2. Make withdrawal");
            System.out.println("3. Make transfer");
            System.out.println("4. Make loan payment");
            System.out.println("5. View account balances");

            int action = getIntInput();
            switch (action) {

                // Make deposit
                case 1:
                    System.out.println("Enter AccountID to deposit to:");
                    int accID = getIntInput();
                    Account account = admin.findAccount(accID);
                    if(account != null) {
                        System.out.println("Your current account details:");
                        account.printAccountDetails();
                        System.out.println("\nEnter dollar amount to deposit:");
                        int deposit = getIntInput();
                        account.makeDeposit(deposit);
                        System.out.println("Deposit successful!\nYour new account details: ");
                        account.printAccountDetails();
                    }
                    else{
                        invalidAccount(accID);
                    }
                    break;

                // Make withdrawal
                case 2:
                    System.out.println("Enter AccountID to withdraw from:");
                    int accID2 = getIntInput();
                    Account account2 = admin.findAccount(accID2);
                    if(account2 != null) {
                        account2.makeWithdrawal();
                    }
                    else{
                        invalidAccount(accID2);
                    }
                    break;

                // Make transfer
                case 3:
                    System.out.println("Enter AccountID to withdraw from:");
                    int accID3 = getIntInput();
                    Account account3 = admin.findAccount(accID3);
                    if (account3 != null) {
                        System.out.println("Enter AccountID to deposit to:");
                        int accID4 = getIntInput();
                        Account account4 = admin.findAccount(accID4);
                        System.out.println("Enter transfer dollar amount: ");
                        int transferAmt = getIntInput();
                        if (account4 != null){
                            boolean compare = account3.checkBalanceValid(transferAmt);
                            account3.withdraw(transferAmt, compare);
                            if(account3.getAccountType().equals("Savings") && compare == false) {}
                            else{ account4.makeDeposit(transferAmt); }
                            account4.printAccountDetails();
                        }else{invalidAccount(accID4);}
                    }else{ invalidAccount(accID3); }

                    break;

                // Make loan payment
                case 4:
                    System.out.println("Enter LoanID to make payment to:");
                    int loanID = getIntInput();
                    Loan loan = admin.findLoan(loanID);
                    if (loan != null) {
                        System.out.println("Your current loan details:");
                        loan.printLoanDetails();
                        System.out.println("\nEnter payment amount: ");
                        int payment = getIntInput();
                        loan.makePayment(payment);
                        System.out.println("\nPayment accepted. Your new loan details: ");
                        loan.printLoanDetails();
                    }
                    else{
                        invalidLoan(loanID);
                    }
                    break;

                // View account balances
                case 5:
                    admin.printCustomerAccounts(custID);
                    break;

                default:
                    System.out.println("Invalid action.");
                    break;
            }
        }
        // else customerID does not exist in system
        else{
            invalidCustomer(custID);
        }
    }
}