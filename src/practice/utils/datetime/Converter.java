package practice.utils.datetime;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Converter {
    public void Date() {
                FastDateFormat f1 = FastDateFormat.getDateTimeInstance(
            Calendar.HOUR_OF_DAY, Calendar.LONG_FORMAT,
            TimeZone.getTimeZone("Asia/Japan"), Locale.JAPAN);
        FastDateFormat f2 = FastDateFormat.getInstance("yyyy-MM-dd:HH-mm-ss");

    }
}
