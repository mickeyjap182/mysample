package practice.basicfeature.novice.threading;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Manager {
    public static final int UNITPRICE = 0;
    public static final int NAME = 1;

    /** generator */
    private static int id = 1;

    private static Integer MAX_POOL_TASKS_COUNT = 10;
    private static Integer poolTaskCount;

    static Object[][] data;
    Map<Long, Detail> details = new HashMap<>();

    List<Thread> tasks;

    public Manager(Object[][] data) {
         poolTasks(data == null ? new Object[][]{{}} : data);
//        poolTaskCount = Integer.valueOf(this.data.length);
    }


    private void poolTasks(Object[][] data) {
        // if task exists, do that.
        this.data = data;
        Supplier<List<Thread>> typeOfLinkedList = () -> new LinkedList<Thread>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        FastDateFormat fdf = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");

        tasks = Arrays.stream(this.data).map(d ->
            new Thread(new Task(id++, details, d, sdf, fdf, this))
        ).collect(Collectors.toCollection(typeOfLinkedList));
        System.out.println(String.format("=== total tasks : %d  . ===", poolTaskCount));
    }

    synchronized public void setPoolTaskCount(Integer i) {
        poolTaskCount = i;
    }

    public boolean execTasks(int atOnce) throws InterruptedException {
        return execTasks(atOnce, 0);
    }
    /**
     *
     * @param atOnce num of a concurrency threads at Once.
     */
    public boolean execTasks(int atOnce, long sleepMilisec) throws InterruptedException {
        if (atOnce < 1) throw new IllegalArgumentException("input more than 0 as a amount of the multi execution.");

        // concurrencty .
        Thread t;
        for (int i = atOnce; i >= 0; i--) {
            t = ((LinkedList<Thread>) tasks).pollFirst();
            if(Objects.isNull(t)) {
                System.out.printf("=== [%d] all task is completed. state: %d ===\n", details.size(), id);
                return false;
            }
            t.start();
            if (sleepMilisec > 0) Thread.sleep(sleepMilisec);

        }
        System.out.printf("=== AtOnce threads has started. ===\n");

        return true;

    }


}
