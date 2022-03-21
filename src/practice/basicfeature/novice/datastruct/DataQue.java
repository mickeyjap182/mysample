package practice.basicfeature.novice.datastruct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DataQue {

    private final ConcurrentLinkedQueue<Map<String, String>> tenantIdQue;
    public DataQue() {
        this.tenantIdQue = new ConcurrentLinkedQueue<>();
    }

    public void execute() {

        // FIFOでキュー

        Map<String, String> m = new HashMap<>();
        m.put("melon company", "aaa");
        m.put("you maths", "abb");
        this.tenantIdQue.add(m);
        Map<String, String> m2 = new HashMap<>();
        m2.put("zozo company", "aaa");
        m2.put("i gata rolus", "abb");
        this.tenantIdQue.add(m2);
    }

    public void executeConcurrent() {

        // FIFOでキュー
        List<Thread> c = List.of(
            new Thread(new ConcurrentQue(this.tenantIdQue, "1st")),
            new Thread(new ConcurrentQue(this.tenantIdQue, "2nd")),
            new Thread(new ConcurrentQue(this.tenantIdQue, "3rd"))
        );

//        for(ConcurrentQue w : c) {
//            w.run();
//        }
//        c.stream().forEach(Thread::start);

        for(Thread thread :c) {
            thread.start();
        }

    }

    public ConcurrentLinkedQueue<Map<String, String>> get() {
        return this.tenantIdQue;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
