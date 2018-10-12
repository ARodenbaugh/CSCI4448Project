Title: Banking System

Description: A Banking System where Customers have bank accounts (checking and savings) and the Bank has an account list that keeps track of account number, owner, and balance as well as a customer list that keeps track of the customerID and their different accounts. The bank can add customers and set up their accounts. The customer can deposit and withdraw from their accounts, and pull loans from the bank.

Actors: Bank, Customer, System

Functionality: 
Customer can make withdrawals from their savings account, so long as withdrawals are less than or equal to the current balance. 
Customer can make withdrawals from their checking account. 
Customer can make deposits to both their saving and checking accounts. 
Bank can add new customers and initialize their checking and savings accounts. 
Bank can add accounts to existing customers. 
Bank can add interest rates to saving accounts. 
System can keep track of the balance of any checking/saving accounts corresponding to a unique customerID and account number pair. 
Customer can view their account balances. 
Bank can view account information with account number, account owner, and balance. 
The customer can pull loans from the bank. 
The customer can make transfers between all of their accounts. 

[OPTIONAL] Stretch Functionality: 
If the customer’s checking account does not have enough for a withdrawal, but there is money in the savings account to cover the transaction, the system will transfer money from saving to checking and complete the withdrawal.
If the customer has no savings account, or both accounts is less than the withdrawal amount, the system will fall to an exception and print out an “insufficient funds” message to the console.
