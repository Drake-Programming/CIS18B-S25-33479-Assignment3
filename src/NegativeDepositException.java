/**
 * Exception thrown when attempting to deposit a negative amount into a bank account.
 * Extends RuntimeException, making it an unchecked exception.
 */
public class NegativeDepositException extends RuntimeException {

    /**
     * Constructs a new NegativeDepositException with the specified detail message.
     *
     * @param message Detailed message explaining why the exception occurred.
     */
    public NegativeDepositException(String message) {
        // Calls the superclass (RuntimeException) constructor with the provided message
        super(message);
    }
}