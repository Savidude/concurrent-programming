package reentrant;

public class ReentrantTest {

    public static void main(String[] args) {
        ReentrantTest test = new ReentrantTest();
        test.a();
    }

    public synchronized void a() {
        System.out.println("Starting method: a()");
        b();
        System.out.println("Finishing method: a()");
    }

    public synchronized void b() {
        System.out.println("Executing method: b()");
    }
}
