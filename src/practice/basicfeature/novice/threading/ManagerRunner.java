package practice.basicfeature.novice.threading;

import java.util.*;

public class ManagerRunner implements Runnable {
    public static final int UNITPRICE = 0;
    public static final int NAME = 1;

    int lock = 0;
    private Integer lockState = lock;

    Integer latestSerialNumber = 0;
    static Object[][] data;
    Map<Long, Detail> details = new HashMap<>();

    public void setTasks(Object[][] data) {
        this.data = data == null ? new Object[][]{{}} : data;
        latestSerialNumber = this.data.length;
    }

    /**
     *
     * @param divide num of a concurrency threads at Once.
     */
    public void execTasks(int divide) throws InterruptedException {
        if (divide < 1) throw new IllegalArgumentException("input more than 0 as a amount of the multi execution.");

        try {

            System.out.println(String.format("=== total threads : %d  . ===", latestSerialNumber));
            // if task exists, do that.
            while (latestSerialNumber > 0) {

                // concurrencty .
                for(int i = divide; i >= 0; i--) {
                    Thread t =  new Thread(this);
                    t.start();

                }
            }
            System.out.printf("=== All threads has started. ===\n");
            Thread.sleep(1000);
            System.out.printf("=== Slept. ===\n");


        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        OnlyOneTask(latestSerialNumber);
    }

    public void OnlyOneTask(Integer id) {

        synchronized(lockState) {
            if (id < 1) {
                System.out.printf("=== [%d] all task is completed. state: %d ===\n", id, lockState);
                return ;
            }

            Detail detail = new Detail();
            Object[] record = data[id-1];
            detail.id = id;
            detail.unitPrice = (Integer) record[Detail.InputDataValue.UNITPRICE.getInputNo()];
            detail.name = record[Detail.InputDataValue.NAME.getInputNo()].toString();
            details.put(Long.valueOf(id), detail);
            latestSerialNumber--;

            System.out.printf("=== [%d] in Synchronized end: %d ===\n", id, lockState);
        }
    }

}
