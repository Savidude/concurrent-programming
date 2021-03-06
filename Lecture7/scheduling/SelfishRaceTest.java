package scheduling;

public class SelfishRaceTest {

    final static int NumRunners = 2;

    public static void main(String args[]) {

        SelfishRunner runners[] = new SelfishRunner[NumRunners];

        for (int i = 0; i < NumRunners; i++) {
            runners[i] = new SelfishRunner(i);

            runners[i].setPriority(2);
        }

        for (int i = 0; i < NumRunners; i++) {
            runners[i].start();
        }

    }
}
