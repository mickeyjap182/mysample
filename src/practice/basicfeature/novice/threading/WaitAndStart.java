package practice.basicfeature.novice.threading;

public class WaitAndStart implements  Runnable {
    public void run() {
        try {
            int count = 0;
            synchronized (this) {
                Thread.sleep(500);
                count++;

            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace(System.out);
            Thread.currentThread().interrupt();
        }
    }
}
