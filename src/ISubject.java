/**
 * Subject interface as part of the Observer design pattern.
 * Defines methods for managing observers and notifying them.
 */
public interface ISubject {

    /**
     * Registers an observer to receive updates from this subject.
     *
     * @param o The observer to register.
     */
    void registerObserver(IObserver o);

    /**
     * Removes a previously registered observer.
     *
     * @param o The observer to remove.
     */
    void removeObserver(IObserver o);

    /**
     * Notifies all registered observers with a message.
     *
     * @param m The message to send to all observers.
     */
    void notifyObservers(String m);
}