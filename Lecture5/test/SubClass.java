public class SubClass extends SuperClass implements Runnable {

    private Thread utilityThread ;

    public SubClass() {

        this.utilityThread = new Thread(this, "utilityThread");
        utilityThread.start();
    }

    @Override
    public void run() {

        // body for the utilityThread
    }
}

