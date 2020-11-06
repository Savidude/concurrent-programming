package SimpleThread;

class TwoThreadsTest {

    public static void main(String[] args) {
        Thread firstThread;
        Thread secondThread;

        firstThread = new SimpleThread("FirstThread");
        secondThread = new SimpleThread("SecondThread");

        firstThread.start();
        secondThread.start();
    }

}