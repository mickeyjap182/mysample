package practice.basicfeature.novice.threading;

public class DeadLock implements  Runnable {
    volatile boolean finished = false;
    private static final int reTry = 3;
    public void run() {
        try {
            int count = 0;
            synchronized (this) {
                while (!finished) {
                    System.out.print(".");
                    Thread.sleep(500);
                    count++;

                    // detect deadLock, and recovery by self.
                    if (count >= reTry) throw new RuntimeException("Dead Locked! but it has been Unlocked!");
                }
            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace(System.out);
            Thread.currentThread().interrupt();
        }
    }
}
