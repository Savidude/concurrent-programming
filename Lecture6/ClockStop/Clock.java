package ClockStop;

import java.applet.Applet;

public class Clock extends Applet implements Runnable {

    private final int ONESECOND = 1000;
    private Thread oneSecondTimer;

    @Override
    public void start() {
        oneSecondTimer = new Thread( this );
        oneSecondTimer.start();
    }

    @Override
    public void stop() {        // Applet "stop" method
        oneSecondTimer.stop();  // Thread "stop" method
    }

    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();

        while (true) {
            try {
                thisThread.sleep(ONESECOND) ;
            } catch (InterruptedException e){ }
            repaint();
        }
    }
}
