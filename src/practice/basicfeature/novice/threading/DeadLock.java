package practice.basicfeature.novice.threading;

public class DeadLock implements  Runnable {
    volatile boolean finished = false;
    public void run() {
        try {
            synchronized (this) {
                while (!finished) {
                    System.out.print(".");
                    Thread.sleep(500);
                }
            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace(System.out);
            Thread.currentThread().interrupt();
        }
    }
}
