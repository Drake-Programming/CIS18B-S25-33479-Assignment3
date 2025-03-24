public class SecureBankAccount extends BankAccountDecorator {
BankAccount bankAccount;
    public SecureBankAccount(BankAccount account) {
        super(account);
        this.bankAccount = account;
    }

    /**
     * Withdraws a specified amount from the account. Notifies observers upon success.
     *
     * @param amount the amount to withdraw, must be positive and not exceed current balance.
     * @throws OverdrawException if the withdrawal amount exceeds current balance.
     * @throws InvalidAccountOperationException if the account is inactive.
     */
    public void withdraw(double amount) throws OverdrawException, InvalidAccountOperationException {
        if (amount > balance) {
            throw new OverdrawException("Cannot withdraw more than the current balance");
        }

        if (!isActive) {
            throw new InvalidAccountOperationException(this.accountNumber + " is not active.");
        }

        if (amount > 500) {
            throw new OverdrawException("Cannot withdraw more than $500");
        }

        this.balance -= amount;
        notifyObservers("Account " + this.accountNumber + " withdrew: $" + amount + "\nNew Balance: " + this.balance);
    }
}
