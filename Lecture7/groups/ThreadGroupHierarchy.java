package groups;

public class ThreadGroupHierarchy {

    public static void main(String[] args) {

        final int NUM_GROUPS = 6;
        final int NUM_THREADS = 7;

        final int TwoSeconds = 2000;

        ThreadGroup[] groups;
        Thread[] threads;

        groups = new ThreadGroup[NUM_GROUPS];
        threads = new Thread[NUM_THREADS];

        // get ``main'' system group
        groups[0] = Thread.currentThread().getThreadGroup();

        // create the thread group hierarchy
        groups[1] = new ThreadGroup(groups[0], "Thread Group A");
        groups[2] = new ThreadGroup(groups[0], "Thread Group B");
        groups[3] = new ThreadGroup(groups[0], "Thread Group C");

        groups[4] = new ThreadGroup(groups[2], "Thread Group B1");
        groups[5] = new ThreadGroup(groups[2], "Thread Group B2");

        // create the threads & place them in the hierarchy
        threads[0] = new Thread(groups[0], "Thread 1");

        threads[1] = new Thread(groups[1], "Thread 2");
        threads[2] = new Thread(groups[1], "Thread 3");

        threads[3] = new Thread(groups[3], "Thread 4");

        threads[4] = new Thread(groups[4], "Thread 5");
        threads[5] = new Thread(groups[4], "Thread 6");

        threads[6] = new Thread(groups[5], "Thread 7");

        // start the threads
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].start();
        }

    }
}
