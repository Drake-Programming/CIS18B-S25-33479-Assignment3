import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with basic operations like deposit, withdrawal, and closing account.
 * Incorporates observer pattern to notify registered observers upon any state changes or account operations.
 */
public class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected boolean isActive;
    private List<Observer> observers = new ArrayList<>();

    /**
     * Constructs a new BankAccount instance.
     *
     * @param accNum the unique account number for this bank account.
     * @param initialBalance the initial amount deposited into the account upon creation.
     */
    public BankAccount(String accNum, double initialBalance) {
        this.accountNumber = accNum;
        this.balance = initialBalance;
        this.isActive = true;
    }

    /**
     * Registers an observer to receive notifications of account changes.
     *
     * @param observer an observer instance implementing the Observer interface.
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Notifies all registered observers with a specified message.
     *
     * @param message the notification message to be sent to observers.
     */
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    /**
     * Deposits a specified amount into the account. Notifies observers upon success.
     *
     * @param amount the amount to deposit, must be positive.
     * @throws NegativeDepositException if the deposit amount is negative.
     * @throws InvalidAccountOperationException if the account is inactive.
     */
    public void deposit(double amount) throws NegativeDepositException, InvalidAccountOperationException {
        if (amount < 0) {
            throw new NegativeDepositException("Must enter a positive number for a deposit");
        }

        if (!isActive) {
            throw new InvalidAccountOperationException(this.accountNumber + " is not active.");
        }

        this.balance += amount;
        notifyObservers("Account " + this.accountNumber + " deposited: $" + amount);
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

        this.balance -= amount;
        notifyObservers("Account " + this.accountNumber + " withdrew: $" + amount);
    }

    /**
     * Retrieves the current balance of the account.
     *
     * @return the current balance of the account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Closes the bank account, setting its active state to false.
     * Notifies observers upon account closure.
     */
    public void closeAccount() {
        this.isActive = false;
        notifyObservers("Account " + this.accountNumber + " is closed.");
    }
}
