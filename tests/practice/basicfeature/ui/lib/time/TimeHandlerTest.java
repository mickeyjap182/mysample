package practice.basicfeature.ui.lib.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeHandlerTest {
    public static final String yyyy_mm_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void currentTest() {
        var now = LocalDateTime.now();
        var currentTime = now.format(DateTimeFormatter.ofPattern(yyyy_mm_dd_HH_mm_ss));
        var builder = new TimeHandler.TimeBuilder();
        var time = builder.time(now)
                .zone(Time.Zone.DEFAULT)
                .build();

        assertEquals(currentTime, time.asString(Time.Format.DEFAULT.format()));
    }
    @Test
    public void targetTimeTest() {
        var time = TimeHandler.of("2022-10-30 13:05:30", Time.Format.DEFAULT.format(), Time.Zone.TOKYO);

        assertEquals("2022-10-30 13:05:30", time.asString(Time.Format.DEFAULT.format()));

        assertEquals("2022-10-30T13:05:30+09:00", time.asString(Time.Format.ISO_BASIC_TIME.format()).substring(0,25));

    }
}