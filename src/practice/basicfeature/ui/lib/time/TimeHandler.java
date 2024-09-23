package practice.basicfeature.ui.lib.time;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

final public class TimeHandler extends Time {

    private final LocalDateTime time;
    private final ZonedDateTime zone;

    private TimeHandler(TimeBuilder builder) {
        super(builder);
        time = builder.time;
        zone = time.atZone(builder.zone.id);
    }

    public String asLocalString(DateTimeFormatter formatter) {
        return time.format(formatter);
    }
    public String asString(DateTimeFormatter formatter) {
        return zone.format(formatter);
    }
    @Override
    public String toString() {
        return zone.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
    public static class TimeBuilder extends Time.Builder<TimeBuilder> {

        private Zone zone;
        private LocalDateTime time;
        public TimeBuilder() {
            super();
        }

        public TimeBuilder zone(Zone zone) {
            this.zone = zone;
            return this;
        }
        public TimeBuilder time(LocalDateTime time) {
            this.time = time;
            return this;
        }
        @Override
        public TimeHandler build() {
            if (this.zone == null) {
                this.zone = Zone.DEFAULT;
            }
            return new TimeHandler(this);
        }

        @Override
        protected TimeBuilder me() {
            return this;
        }
    }

    public static TimeHandler create(TimeHandler time, Zone zone) {
        // タイムゾーン変換
        var newZone = time.zone.withZoneSameInstant(zone.id);
        var newTime = newZone.toLocalDateTime();
        return new TimeBuilder()
                .time(newTime)
                .zone(zone)
                .build();
        // ↓だけに変換するメソッドが欲しいかも
//                withZoneSameInstant(zone.id);
    }
    public static LocalDateTime now(){
        return LocalDateTime.now();
    }

    public static TimeHandler of(String time, DateTimeFormatter fmt, Zone zone) {
        return new TimeBuilder()
                .time(LocalDateTime.parse(time, fmt))
                .zone(zone)
                .build();

    }

}