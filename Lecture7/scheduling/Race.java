package scheduling;


public class Race extends Thread {

    final static int NUMRUNNERS = 2;

    Runner[] runners = new Runner[NUMRUNNERS];

    public Race(String raceType) {
        for (int i = 0; i < NUMRUNNERS; i++) {
            runners[i] = new Runner(i);

            if (raceType.equals("unfair"))
                runners[i].setPriority(i + 1);
            else
                runners[i].setPriority(2);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMRUNNERS; i++) {
            if (!runners[i].isAlive()) {
                runners[i].start();
            }
        }

        while (isRunnersAlive()) {
            String runnerStatus = "";
            for (Runner runner : runners) {
                runnerStatus += String.format("%s: tick = %d\t", runner.getName(), runner.tick);
            }
            System.out.println(runnerStatus);

            try {
                this.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    public void stopRunners() {
        for (int i = 0; i < NUMRUNNERS; i++) {
            // Terminate Runner thread
            if (runners[i].isAlive()) {
                runners[i].terminate = true;
                runners[i] = null;
            }
        }
    }

    private boolean isRunnersAlive() {
        for (Runner runner : runners) {
            if (runner.isAlive()) {
                return true;
            }
        }
        return false;
    }
}
