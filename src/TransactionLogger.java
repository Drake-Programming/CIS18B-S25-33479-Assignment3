/**
 * TransactionLogger is a concrete observer implementing the IObserver interface.
 * Logs transaction-related messages when notified.
 */
public class TransactionLogger implements IObserver {

    /**
     * Handles receiving an update by printing the message.
     *
     * @param message The message received from the subject.
     */
    public void update(String message) {
        // Log the transaction message to the console
        System.out.println(message);
    }
}