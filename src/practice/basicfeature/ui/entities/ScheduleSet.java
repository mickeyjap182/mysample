package practice.basicfeature.ui.entities;

import practice.basicfeature.ui.entities.scheduleset.LongRest;
import practice.basicfeature.ui.entities.scheduleset.Rest;
import practice.basicfeature.ui.entities.scheduleset.Work;

import java.util.ArrayList;
import java.util.List;

public class ScheduleSet {
    private static ScheduleSet INSTANCE;
    private final List<Work> works;
    private final List<Rest> rest;
    private final List<LongRest> longRest;

    private ScheduleSet() {
        this.works = new ArrayList<>();
        this.rest = new ArrayList<>();
        this.longRest = new ArrayList<>();
    }

    public static ScheduleSet getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScheduleSet();
        }
        return INSTANCE;
    }
    public void addToWork(Work work) {
        works.add(work);
    }

    public void addToLongRest(LongRest longRest) {
        this.longRest.add(longRest);
    }
    public void addToRest(Rest rest) {
        this.rest.add(rest);
    }

}
