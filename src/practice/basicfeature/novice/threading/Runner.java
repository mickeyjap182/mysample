package practice.basicfeature.novice.threading;

public class Runner {

    public static void main(String[] args) {

        // start manager process
        ManagerRunner m = new ManagerRunner();
        m.setTasks(findData());

        System.out.println("==start==");
//         start multi threading.
//        Thread thread = new Thread(m);
//        thread.start();

        // non blocking.


        // block until threads ends.
        try {
            m.execTasks(2);
            System.out.printf("=== Threads ended. ===\n");

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // all threads result.
        m.details.values().stream().forEach(v -> {
            System.out.println(v.id);
            System.out.println(v.unitPrice);
            System.out.println(v.name);
        });

        // Dead Lock
        Object obj = new Object();
        DeadLock test = new DeadLock();
        Thread th = new Thread(test, "Child");
        try {
            th.start();
            Thread.sleep(5000);
            synchronized (test) {
                test.finished = true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static Object[][] findData() {
        Object[][] data = new Object[][] {
            {100, "pencil"},
            {200, "pen"},
            {300, "note"},
            {100, "eraser"}
        };
        return data;
    }

}
