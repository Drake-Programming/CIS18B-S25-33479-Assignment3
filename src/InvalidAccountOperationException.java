/**
 * Custom unchecked exception representing invalid operations
 * attempted on bank accounts, such as invalid deposits or withdrawals.
 * Extends RuntimeException, thus it's unchecked.
 */
public class InvalidAccountOperationException extends RuntimeException {

    /**
     * Constructs a new InvalidAccountOperationException with a specified detail message.
     *
     * @param message Detailed message explaining the cause of the exception.
     */
    public InvalidAccountOperationException(String message) {
        // Calls the superclass constructor with the provided message
        super(message);
    }
}
