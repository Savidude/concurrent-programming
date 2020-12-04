package producerConsumer;

public class ProducerConsumer {

    public static void main(String[] args) {
        final int NUMB_ITEMS = 10;
        final int BUFFER_CAPACITY = 6;

        // create shared buffer
        Buffer buffer = new SharedBuffer(BUFFER_CAPACITY);

        // create 2 producer & 2 consumer threads
        Producer p1 = new Producer(buffer, 1, NUMB_ITEMS);
        Producer p2 = new Producer(buffer, 2, NUMB_ITEMS);
        Consumer c1 = new Consumer(buffer, 1, NUMB_ITEMS);
        Consumer c2 = new Consumer(buffer, 2, NUMB_ITEMS);


        // start threads
        p1.start();
        p2.start();

        c1.start();
        c2.start();

        // wait for all 4 threads to terminate
        try {
            p1.join();
            p2.join();

            c1.join();
            c2.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Final Buffer State: " + buffer);
    }
}
