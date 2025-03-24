/**
 * Decorator class for BankAccount.
 * This class allows additional functionalities to be added dynamically
 * to BankAccount objects without altering their original structure.
 */
public class BankAccountDecorator extends BankAccount {

    /**
     * The BankAccount instance that is being decorated.
     */
    protected BankAccount decoratedAccount;

    /**
     * Constructor to create a decorator for a BankAccount.
     *
     * @param account The BankAccount instance to decorate.
     */
    public BankAccountDecorator(BankAccount account) {
        // Initialize the superclass (BankAccount) with account details
        super(account.accountNumber, account.getBalance());

        // Assign the BankAccount instance to be decorated
        this.decoratedAccount = account;
    }
}
