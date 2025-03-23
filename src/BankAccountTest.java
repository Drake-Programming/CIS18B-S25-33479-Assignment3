import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // TODO: Ask the user to enter an initial balance and create a BankAccount object
            // Example: System.out.print("Enter initial balance: ");
            //          double initialBalance = scanner.nextDouble();
            //          BankAccount account = new BankAccount("123456", initialBalance);

            System.out.println("Bank Account Created: #123456");

            // TODO: Create a TransactionLogger and attach it to the account

            // TODO: Wrap account in SecureBankAccount decorator

            // TODO: Allow the user to enter deposit and withdrawal amounts
            // Example: secureAccount.deposit(amount);
            // Example: secureAccount.withdraw(amount);

            // TODO: Display the final balance

        } catch (Exception e) {
            // TODO: Catch and handle exceptions properly
        } finally {
            scanner.close();
        }
    }
}