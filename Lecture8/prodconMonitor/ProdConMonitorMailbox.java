package prodconMonitor;

import prodcon.Consumer;
import prodcon.Mailbox;
import prodcon.Producer;

public class ProdConMonitorMailbox {

    public static void main(String[] args) {
        final int NUMBITEMS = 10;
        // Create: MailboxMonitor, Producer & Consumer
        Mailbox mbm = new MonitorMailbox();
        Producer p1 = new Producer(mbm, 1, NUMBITEMS);
        Consumer c1 = new Consumer(mbm, 1, NUMBITEMS);
        // Start Producer & Consumer
        p1.start();
        c1.start();
    }
}
