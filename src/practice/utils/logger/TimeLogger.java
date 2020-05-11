package practice.utils.logger;


public class TimeLogger {
    public static final String format = "====== elaspedTime:%.3f millisec [ %s ]======\n";

    private long startNanoTime;

    private TimeLogger() {
        startNanoTime = System.nanoTime();
    }
    public static TimeLogger getLogger() {
        return new TimeLogger();
    }

    public void info(String message) {
        long elapsedTime = System.nanoTime() - startNanoTime;
        System.out.printf(format, toMillSec(elapsedTime), message);
    }

    private double toMillSec(long nanoTime) {
        return (double)nanoTime / 1000000;
    }
}
