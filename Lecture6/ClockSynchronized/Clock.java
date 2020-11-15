package ClockSynchronized;

import java.applet.Applet;

public class Clock extends Applet implements Runnable {

    private final int ONESECOND = 1000;
    private Thread oneSecondTimer;
    private boolean terminateThread = false;

    private synchronized void terminate() {
        terminateThread = true;
    }

    private synchronized boolean isNotTerminated() {
        return !terminateThread;
    }

    @Override
    public void start() {
        oneSecondTimer = new Thread( this );
        oneSecondTimer.start();
    }

    @Override
    public void stop() {        // Applet "stop" method
        terminate();
    }

    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (isNotTerminated()) {
            try {
                thisThread.sleep(ONESECOND) ;
            } catch (InterruptedException e){ }
            repaint();
        }
    }
}
