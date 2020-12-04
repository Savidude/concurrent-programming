package producerConsumer;

public class Producer extends Thread {

    private final int MAX_SLEEP_TIME = 1000;  // 1 second
    private final Buffer buffer;
    private final int ITEMS_COUNT;
    private final int FIRST_ITEM;

    public Producer(Buffer buffer, int PID, int numbItems) {
        super("Producer_" + PID);

        this.buffer = buffer;
        this.ITEMS_COUNT = numbItems;

        // calculate the first value to produce for this Producer
        this.FIRST_ITEM = (PID - 1) * ITEMS_COUNT;
    }

    @Override
    public void run() {
        for (int i = FIRST_ITEM; i < FIRST_ITEM + ITEMS_COUNT; i++) {
            buffer.put(i);
            System.out.println(getName() + " produced: " + i);
            try {
                sleep((int) (Math.random() * MAX_SLEEP_TIME));
            } catch (InterruptedException e) {
            }
        }

        System.out.println(getName() +
                " TOTAL Items Produced: " +
                ITEMS_COUNT);
    }
}
