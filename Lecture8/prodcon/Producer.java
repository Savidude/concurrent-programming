package prodcon;

public class Producer extends Thread {

    private final Mailbox mailbox; // Mailbox "interface"
    private final int numberOfItems;

    public Producer(Mailbox mailbox, int producerID, int numberOfItems) {
        super("Producer #" + producerID);  // Thread( thrd_name )
        this.mailbox = mailbox;
        this.numberOfItems = numberOfItems;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfItems; i++) {
            mailbox.put(i);
            System.out.println(getName() + " put:   " + i);
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
