package practice.basicfeature.novice.threading;

import java.util.*;

public class Multi implements  Runnable {
    public static final int UNITPRICE = 0;
    public static final int NAME = 1;

    int lock = 0;
    private Integer lockState = lock;

    Integer latestSerialNumber = 0;
    Object[][] data;
    Map<Long, Detail> details = new HashMap<>();

    public void setTasks(Object[][] data) {
        this.data = data;
    }

    @Override
    public void run() {

        OnlyOneTask(latestSerialNumber);
    }

    public void OnlyOneTask(Integer id) {

        synchronized(id) {

            Detail detail = new Detail();
            Object[] record = data[id-1];
            detail.id = id;
            detail.unitPrice = (Integer) record[Detail.InputDataValue.UNITPRICE.getInputNo()];
            detail.name = record[Detail.InputDataValue.NAME.getInputNo()].toString();
            details.put(Long.valueOf(id), detail);

            System.out.printf("=== [%d] in Synchronized end: %d ===\n", id, lockState);
        }
    }

}
