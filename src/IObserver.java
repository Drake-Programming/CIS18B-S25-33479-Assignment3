/**
 * Observer interface as part of the Observer design pattern.
 * Defines a method for receiving updates from subjects.
 */
public interface IObserver {

    /**
     * Receives a notification or update from a subject.
     *
     * @param message The message sent from the subject to observers.
     */
    void update(String message);
}