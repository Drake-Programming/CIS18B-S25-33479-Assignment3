/**
 * BankAccountTest class to demonstrate basic bank operations such as deposit and withdrawal.
 * Utilizes decorator and observer patterns through SecureBankAccount and TransactionLogger.
 */

import java.util.Scanner;

public class BankAccountTest {

    /**
     * Entry point for the bank account testing program.
     * Allows users to create a bank account, deposit, withdraw, and exit.
     * Handles user inputs and exceptions gracefully.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean programRunning = true;
        double amount = 0;
        String accountName;
        BankAccount account;
        SecureBankAccount secureAccount;
        int choice;
        TransactionLogger transactionLogger = new TransactionLogger();

        // Prompt for account number input
        System.out.print("Enter account number: ");
        accountName = scanner.nextLine();

        // Attempt to initialize bank account with initial balance
        try {
            System.out.println("Enter initial balance: ");
            amount = scanner.nextDouble();
            account = new BankAccount(accountName, amount);
        } catch (java.util.InputMismatchException ime) {
            // Handle incorrect numeric input and set default values
            System.out.println("\nInput only numeric values\n");
            scanner.nextLine(); // clear buffer
            account = new BankAccount("12345", 0);
        }
        System.out.println("Bank Account Created: " + account.accountNumber);

        // Decorate account with security features
        secureAccount = new SecureBankAccount(account);
        // Register logger as an observer for transactions
        secureAccount.registerObserver(transactionLogger);

        // User interaction loop for banking operations
        try {
            do {
                System.out.println("--Welcome to Simple Bank System--\n1. Deposit Money\n2. Withdraw Money\n3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1: // Deposit operation
                        try {
                            System.out.print("Enter deposit amount: ");
                            amount = scanner.nextDouble();
                        } catch (java.util.InputMismatchException ime) {
                            System.out.println("\nInput only numeric values\n");
                            scanner.nextLine();
                            continue;
                        }
                        secureAccount.deposit(amount);
                        break;

                    case 2: // Withdraw operation
                        try {
                            System.out.print("Enter withdraw amount: ");
                            amount = scanner.nextDouble();
                        } catch (java.util.InputMismatchException ime) {
                            System.out.println("\nInput only numeric values\n");
                            scanner.nextLine();
                            continue;
                        }
                        secureAccount.withdraw(amount);
                        break;

                    case 3: // Exit the program
                        programRunning = false;
                        System.out.println("Thank you for using Simple Bank System!");
                        break;

                    default: // Handle invalid menu choices
                        System.out.println("Invalid choice, please select 1, 2, or 3.");
                }

            } while (programRunning);

        } catch (java.util.InputMismatchException ime) {
            // Catch any unexpected input exceptions in the main loop
            System.out.println("\nInput only numeric values\n");
        } finally {
            // Ensure scanner resource is always closed to avoid resource leaks
            scanner.close();
        }
    }
}
