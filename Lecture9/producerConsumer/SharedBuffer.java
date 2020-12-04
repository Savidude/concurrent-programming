package producerConsumer;

public class SharedBuffer implements Buffer {

    private final char TAB = '\t';

    private final int SLOT_EMPTY = -99;

    private final int[] buffer;
    private final int CAPACITY;

    private int putIndex = 0;
    private int takeIndex = 0;

    private int numberOfItems = 0;

    public SharedBuffer(int capacity) {
        CAPACITY = capacity;
        buffer = new int[CAPACITY];

        intitializeBuffer(SLOT_EMPTY);
    }

    protected void intitializeBuffer(int INIT_VALUE) {
        for (int i = 0; i < CAPACITY; i++) {
            buffer[i] = INIT_VALUE;
        }
    }

    @Override
    public synchronized void put(int item) {
        // Wait until buffer is "not full"
        while (isFull()) {
            try {
                System.out.println("Buffer:FULL -> put WAIT");
                wait();
            } catch (InterruptedException e) {
            }
        }
        // !isFull() => place item into buffer

        // Place item into buffer
        buffer[putIndex] = item;

        // move pointer to next empty slot
        putIndex = (putIndex + 1) % CAPACITY;
        numberOfItems++;

        System.out.println("Buffer:put(" + item + "): " + TAB +
                (item < 10 ? TAB : "") + // line up output
                this);

        // signal a "change of state"
        notifyAll();
    }

    @Override
    public synchronized int take() {
        // Wait until buffer is "not empty"
        while (isEmpty()) {
            try {
                System.out.println("Buffer:EMPTY -> take WAIT");
                wait();
            } catch (InterruptedException e) {
            }
        }
        // !isEmpty() => remove item from buffer

        // Remove item from buffer
        int removedItem = buffer[takeIndex];
        buffer[takeIndex] = SLOT_EMPTY;

        // move index to point to next item to take
        takeIndex = (takeIndex + 1) % CAPACITY;
        numberOfItems--;

        System.out.println("Buffer:take(" + removedItem + "): " + TAB + this);

        // signal a "change of state"
        notifyAll();
        return removedItem;
    }

    protected boolean isFull() {
        return (numberOfItems == CAPACITY);
    }

    protected boolean isEmpty() {
        return (numberOfItems == 0);
    }

    @Override
    public String toString() {
        return TAB +
                "[ COUNT = " + numberOfItems + "/" + CAPACITY +
                " | IN = " + putIndex +
                " | OUT = " + takeIndex +
                " | " + contentsToString() + " ]";
    }

    protected String contentsToString() {
        String contents = "";

        for (int i = 0; i < CAPACITY; i++) {
            contents += (buffer[i] + " ");
        }

        return "< " + contents + ">";
    }
}
