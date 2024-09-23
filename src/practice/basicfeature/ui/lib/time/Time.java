package practice.basicfeature.ui.lib.time;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public abstract class Time {
    public enum Format {
        DEFAULT("yyyy-MM-dd HH:mm:ss")
        , SLASH("yyyy/MM/dd HH:mm:ss")
        , ISO_BASIC_TIME(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        , ISO_ZONED_TIME(DateTimeFormatter.ISO_ZONED_DATE_TIME)
        ;

        private final DateTimeFormatter fmt;

        Format(String fmt) {
            this.fmt = DateTimeFormatter.ofPattern(fmt);
        }
        Format(DateTimeFormatter fmt) {
            this.fmt = fmt;
        }

        DateTimeFormatter format() {
            return fmt;
        }
    }
    public enum Zone {
        DEFAULT(ZoneId.of("Asia/Tokyo")),
        TOKYO(ZoneId.of("Asia/Tokyo")),
        SGP(ZoneId.of("Asia/Singapore")),
        UTC(ZoneOffset.UTC);

        public ZoneId id;

        Zone(ZoneId id) {
            this.id = id;
        }
        // ZoneOffset.JST
    }
    abstract static class Builder<T extends Builder<T>>{

        protected Builder() {

        }
        abstract public Time build();
        abstract protected T me();
    }

    Time(Builder<?> builder) {

    }
}
