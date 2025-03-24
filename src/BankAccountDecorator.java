public class BankAccountDecorator extends BankAccount {
    protected BankAccount decoratedAccount;

    public BankAccountDecorator(BankAccount account) {
        super(account.accountNumber, account.getBalance());
        this.decoratedAccount = account;
    }
}