public class TransactionLogger implements IObserver {
    public void update(String message) {
        System.out.println(message);
    }
}
