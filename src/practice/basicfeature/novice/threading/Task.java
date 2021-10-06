package practice.basicfeature.novice.threading;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.SimpleDateFormat;
import java.util.Map;

public class Task implements Runnable{
    private SimpleDateFormat sdf;
    private FastDateFormat fdf;

    private final Map<Long, Detail> details;
    private final Object[] record;
    private final int id;

    private Boolean isManagerBusy;
    private final Manager manager;

    public Task(Integer id, Map<Long, Detail> details, Object[] record,  SimpleDateFormat sdf, FastDateFormat fdf, Manager m ) {
        this.id = id;
        this.details = details;
        this.record = record;
        this.sdf = sdf;
        this.fdf = fdf;
        manager = m;
    }

    @Override
    public void run() {
        makeDetail(new Detail());
    }

    public void makeDetail(Detail detail) {


        detail.id = id;
        detail.unitPrice = (Integer) record[Detail.InputDataValue.UNITPRICE.getInputNo()];
        detail.name = record[Detail.InputDataValue.NAME.getInputNo()].toString();
        details.put(Long.valueOf(id), detail);
        manager.setPoolTaskCount(manager.tasks.size());

        System.out.printf("=== [%d] in Synchronized end: %d simpleDateFormat: %s FastDateFormat: %s ===\n", details.size(), id, sdf, fdf);
    }
}
