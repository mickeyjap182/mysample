package practice.basicfeature.novice.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarDate {
    public void exec() {
        GregorianCalendar g = new GregorianCalendar();
        Date g3 = new GregorianCalendar(
                g.get(Calendar.YEAR),
                g.get(Calendar.MONTH),
                g.get(Calendar.DATE),
                g.get(Calendar.HOUR) , // 12h表記
                g.get(Calendar.MINUTE)
        ).getTime();
        System.out.println(g3);

        String g2 = new GregorianCalendar(
                g.get(Calendar.YEAR),
                g.get(Calendar.MONTH),
                g.get(Calendar.DATE),
                g.get(Calendar.HOUR_OF_DAY), // 24h表記
                g.get(Calendar.MINUTE)
        ).getTime().toString();
        System.out.println(g2);

    }

    public static Date getTargetDate(Date targetDate) {
        Date currentTargetDate = null;
        if (targetDate != null) {
            Calendar baseTargetDate = new GregorianCalendar();
            baseTargetDate.setTime(targetDate);
            Calendar today = new GregorianCalendar(
                    baseTargetDate.get(Calendar.YEAR),
                    baseTargetDate.get(Calendar.MONTH),
                    baseTargetDate.get(Calendar.DATE)
                    );
            currentTargetDate = today.getTime();

        }
        return currentTargetDate;
        
    }
}
