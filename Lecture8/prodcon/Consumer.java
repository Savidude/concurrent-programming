package prodcon;

public class Consumer extends Thread {

    private final Mailbox mailbox; // Mailbox "interface"
    private final int numberOfItems;
    private final int[] valuesConsumed;

    public Consumer(Mailbox mailbox, int consumerID, int numberOfItems) {
        super("Consumer #" + consumerID);  // Thread( thrd_name )
        this.mailbox = mailbox;
        this.numberOfItems = numberOfItems;

        valuesConsumed = new int[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            valuesConsumed[i] = -99;
        }
    }

    @Override
    public void run() {
        int[] valuesConsumed = new int[numberOfItems];
        int value;


        for (int i = 0; i < numberOfItems; i++) {
            value = mailbox.take();
            valuesConsumed[i] = value;
            System.out.println(getName() + " taken: " + value);
        }

        System.out.print(getName() + " consumed: < ");
        for (int i = 0; i < numberOfItems; i++) {
            System.out.print(valuesConsumed[i] + " ");
        }
        System.out.println(">");
    }
}
