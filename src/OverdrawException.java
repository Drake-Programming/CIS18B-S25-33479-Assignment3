/**
 * Exception thrown when attempting to withdraw an amount greater than the current account balance.
 * Extends RuntimeException, making it an unchecked exception.
 */
public class OverdrawException extends RuntimeException {

    /**
     * Constructs a new OverdrawException with the specified detail message.
     *
     * @param message Detailed message explaining why the exception occurred.
     */
    public OverdrawException(String message) {
        // Calls the superclass (RuntimeException) constructor with the provided message
        super(message);
    }
}