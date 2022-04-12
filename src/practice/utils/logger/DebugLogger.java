package practice.utils.logger;

import java.io.OutputStream;
import java.io.PrintStream;

public class DebugLogger {
    public enum IOResource {
        FILE,
        CONSOLE;
    }
    private static final String FORMAT = "==== phase: %d  contents:%s ====";
    private int index;
    private String message;
    public DebugLogger() {
        index = 0;
        message = "started";
    }
    public void addPhase(String message) {
        this.message = message;
    }
    public void next(String message) {
        addPhase(message);
        index++;
    }

    public boolean logging(OutputStream o, IOResource resource, Pattern pattern) {
        index = pattern.id;
        message = pattern.detail;
        return logging(o, resource);
    }
    public boolean logging(OutputStream o, IOResource resource) {
        String message = String.format(FORMAT, index, this.message);
        switch (resource) {
            case CONSOLE:
                ((PrintStream)o).println(message);

            case FILE:
            default:
                break;
        }
        return true;
    }

    public int getPattern() {
        return index;
    }
}
