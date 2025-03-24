/**
 * Interface representing basic banking operations.
 * Classes implementing this interface must provide
 * concrete implementations for deposit, withdraw,
 * and balance inquiry functionalities.
 */
public interface IAccount {

    /**
     * Deposits a specified amount into the account.
     *
     * @param amount The amount to deposit.
     */
    void deposit(double amount);

    /**
     * Withdraws a specified amount from the account.
     *
     * @param amount The amount to withdraw.
     */
    void withdraw(double amount);

    /**
     * Retrieves the current balance of the account.
     *
     * @return The current account balance.
     */
    double getBalance();
}
