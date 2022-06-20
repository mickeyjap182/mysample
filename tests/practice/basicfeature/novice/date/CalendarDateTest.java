package practice.basicfeature.novice.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CalendarDateTest {
    @Test
    public void testDo() {
        new CalendarDate().exec();
        assertTrue(true);
    }
    @Test
    public void testtimeChecker() {
        {
            // 時分
            var time = LocalTime.parse("10:00", DateTimeFormatter.ofPattern("HH:mm").withResolverStyle(ResolverStyle.STRICT));
            var legacyTime  = Date.from(time.atDate(LocalDate.EPOCH).atZone(ZoneOffset.systemDefault()).toInstant());
            assertEquals("10:00", time.toString());
        }

        {
            // invalid年月日
            try {
                var date = LocalDate.parse("2022/11/31", DateTimeFormatter.ofPattern("uuuu/MM/dd").withResolverStyle(ResolverStyle.STRICT));
                var legacyDate = Date.from(date.atStartOfDay(ZoneOffset.systemDefault()).toInstant());
//            assertEquals(legacyDate.toInstant()format(DateTimeFormatter.ofPattern("uuuu/MM/dd"), "2022/11/31"));
                assertEquals("2022/11/31", date.format(DateTimeFormatter.ofPattern("uuuu/MM/dd")));

            } catch ( DateTimeParseException | AssertionError e) {
                assertTrue(e instanceof DateTimeParseException);
                assertTrue(true);
            }

        }
    }




}