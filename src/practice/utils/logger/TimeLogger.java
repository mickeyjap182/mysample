package practice.utils.logger;


public class TimeLogger {
    public static final String format = "====== elaspedTime:%.3f millisec [ %s ]======\n";

    private static long startNanoTime;

    /**
     * same. because of a utility class.
     **/
    private TimeLogger(){}
    static {
        startNanoTime = System.nanoTime();
    }
    public static TimeLogger getLogger() {
        return new TimeLogger();
    }

    public void info(String message) {
        long elapsedTime = System.nanoTime() - startNanoTime;
        System.out.printf(format, toMillSec(elapsedTime), message);
    }

    public void resetElaspedTime() {
        startNanoTime = System.nanoTime();
    }

    private double toMillSec(long nanoTime) {
        return (double)nanoTime / 1000000;
    }
}
