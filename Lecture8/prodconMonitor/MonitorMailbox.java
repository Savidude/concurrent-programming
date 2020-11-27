package prodconMonitor;

import prodcon.Mailbox;

public class MonitorMailbox implements Mailbox {

    private int contents;
    private boolean available = false;

    @Override
    public synchronized void put(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        contents = value;

        available = true;

        notifyAll();

        printState("put(" + value + ")  ");
    }

    @Override
    public synchronized int take() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        available = false;

        notifyAll();

        printState("take():" + contents);

        return contents;
    }

    public void printState(String operation) {
        System.out.println("MonitorMailbox." + operation + this);
    }

    public String toString() {
        return new String("[ contents = " + contents +
                " , available = " + available + " ]");
    }
}
