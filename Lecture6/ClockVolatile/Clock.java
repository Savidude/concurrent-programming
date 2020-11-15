package ClockVolatile;

import java.applet.Applet;

public class Clock extends Applet implements Runnable {

    private final int ONESECOND = 1000;
    private volatile Thread oneSecondTimer;

    @Override
    public void start() {
        oneSecondTimer = new Thread( this );
        oneSecondTimer.start();
    }

    @Override
    public void stop() {        // Applet "stop" method
        oneSecondTimer = null;
    }

    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();

        while (oneSecondTimer == thisThread) {
            try {
                thisThread.sleep(ONESECOND) ;
            } catch (InterruptedException e){ }
            repaint();
        }
    }
}
