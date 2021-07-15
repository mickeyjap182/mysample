package practice.utils.datastruct;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Que {

    final private BlockingQueue<String> que;
    private Boolean isLock;
    public Que(int size) {
        que = new LinkedBlockingQueue<>(size);
        isLock = false;
    }

    public void put(String message) {
        synchronized(isLock) {
            try {
                que.put(message);

            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String poll() {
        synchronized(isLock) {
            String message = que.poll();
            return message;
        }
    }
}
