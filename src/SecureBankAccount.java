/**
 * SecureBankAccount extends BankAccountDecorator to add additional security
 * and observer notification capabilities to basic banking operations.
 * Implements withdrawal with limits and notifies observers upon transactions.
 */
public class SecureBankAccount extends BankAccountDecorator {

    // The underlying bank account being secured
    BankAccount bankAccount;

    /**
     * Constructs a new SecureBankAccount decorator for an existing BankAccount.
     *
     * @param account The BankAccount to be decorated with security features.
     */
    public SecureBankAccount(BankAccount account) {
        super(account);
        this.bankAccount = account;
    }

    /**
     * Withdraws a specified amount from the account, enforcing additional security constraints.
     * Observers are notified upon successful withdrawal.
     *
     * @param amount the amount to withdraw; must be positive and within allowed limits.
     * @throws OverdrawException if withdrawal exceeds the current balance or allowed limits.
     * @throws InvalidAccountOperationException if the account is inactive.
     */
    public void withdraw(double amount) throws OverdrawException, InvalidAccountOperationException {
        // Check if sufficient balance is available
        if (amount > balance) {
            throw new OverdrawException("Cannot withdraw more than the current balance");
        }

        // Verify account status is active
        if (!isActive) {
            throw new InvalidAccountOperationException(this.accountNumber + " is not active.");
        }

        // Enforce maximum withdrawal limit of $500
        if (amount > 500) {
            throw new OverdrawException("Cannot withdraw more than $500");
        }

        // Deduct the amount from the account balance
        this.balance -= amount;

        // Notify observers of the transaction
        notifyObservers("Account " + this.accountNumber + " withdrew: $" + amount + "\nNew Balance: " + this.balance);
    }
}
