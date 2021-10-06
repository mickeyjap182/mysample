package practice.basicfeature.novice.threading;

import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void test_go() {
        try {

            // start manager process
            Manager m = new Manager(findData());
            System.out.println("==start==");

            // non blocking.

            // block until threads ends.
            try {
                boolean is_executable = true;
                while(is_executable) {
                    is_executable = m.execTasks(2, 1000);
                }
                System.out.printf("=== All threads has terminated. ===\n");

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            // all threads result.
            m.details.values().stream().forEach(v -> {
                System.out.println(v.id);
                System.out.println(v.unitPrice);
                System.out.println(v.name);
            });



        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_deadLock() {
        try {
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
            catch (RuntimeException ex) {
                ex.printStackTrace(System.out);
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
            }

        } catch(Exception e) {
            e.printStackTrace();
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
