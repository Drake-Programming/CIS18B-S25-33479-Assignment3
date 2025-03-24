import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean programRunning = true;
        double amount = 0;
        String accountName;
        BankAccount account;
        SecureBankAccount secureAccount;
        int choice;
        TransactionLogger transactionLogger = new TransactionLogger();

        System.out.print("Enter account number: ");
        accountName = scanner.nextLine();

        try {
            System.out.println("Enter inital balance: ");
            amount = scanner.nextDouble();
            account = new BankAccount(accountName, amount) {
            };
        } catch (java.util.InputMismatchException ime) {
            System.out.println("\nInput only numeric values\n");
            scanner.nextLine();
            account = new BankAccount("12345", 0);
        }
        System.out.println("Bank Account Created: " + account.accountNumber);

        secureAccount = new SecureBankAccount(account);
        secureAccount.registerObserver(transactionLogger);
        try {
            do {
                System.out.println("--Welcome to Simple Bank System--\n1. Deposit Money\n2. Withdraw Money\n3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter deposit amount: ");
                            amount = scanner.nextDouble();
                        } catch (java.util.InputMismatchException ime) {
                            System.out.println("\nInput only numeric values\n");
                            scanner.nextLine();
                        }
                        secureAccount.deposit(amount);
                        break;
                    case 2:
                        try {
                            System.out.print("Enter withdraw amount: ");
                            amount = scanner.nextDouble();
                        } catch (java.util.InputMismatchException ime) {
                            System.out.println("\nInput only numeric values\n");
                            scanner.nextLine();
                        }
                        secureAccount.withdraw(amount);
                        break;
                    case 3:
                        programRunning = false;
                        scanner.close();
                        System.out.println("Thank you for using Simple Bank System!");
                }
            } while (programRunning);

        } catch (java.util.InputMismatchException ime) {
            System.out.println("\nInput only numeric values\n");
            scanner.nextLine();
        } finally {
            scanner.close();
        }
    }
}