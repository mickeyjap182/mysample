package practice.utils.process;


import java.util.Timer;
import java.util.TimerTask;

public class TimeWatch {

    Timer time;
    /**
     * same. because of a utility class.
     **/
    public void TimeWatch(){
        time = new Timer();

    }

    public void addTask(TimerTask task) {
//        time.scheduleAtFixedRate(task);

    }


}
