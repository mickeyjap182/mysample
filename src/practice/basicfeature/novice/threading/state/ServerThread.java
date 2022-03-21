package practice.basicfeature.novice.threading.state;

import java.util.concurrent.atomic.AtomicBoolean;

public class ServerThread {
    private final String filePath;
    private final AtomicBoolean isRunning;

    public ServerThread(int interval) {
        isRunning = new AtomicBoolean(false);
        filePath = "";
    }

    public static class ChildThread implements Runnable {
        private final int rownum;
        private final String[] line;
        public ChildThread(int rownum, String[] line) {
            this.rownum = rownum;
            this.line = line;
        }

        @Override
        public void run() {


        }

    }
}
