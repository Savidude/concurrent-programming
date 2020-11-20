package groups;

public class ListThreadsInGroup {

    public static void main(String[] args) {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        listThreadsInGroup( currentGroup ) ;
    }

    private static void listThreadsInGroup(ThreadGroup threadGroup) {

        int ac_count = threadGroup.activeCount();

        // allow a margin of error in the size of the array
        Thread[] listOfThreads = new Thread[ac_count * 2];
        int e_count = threadGroup.enumerate(listOfThreads);
        System.out.println("Threads in " + threadGroup.getName());
        for (int i = 0; i < e_count; i++) {
            System.out.println("Thread #" + i + " = " + listOfThreads[i].getName());
        }
    }
}
