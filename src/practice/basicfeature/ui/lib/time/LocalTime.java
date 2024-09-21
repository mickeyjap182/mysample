package practice.basicfeature.ui.lib.time;

import practice.basicfeature.ui.lib.time.Consts.Format;
import practice.basicfeature.ui.lib.time.Consts.TimeZone;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

final public class LocalTime extends Time {

    private final LocalDateTime time;
    private final ZonedDateTime zone;

    private LocalTime(LocalTimeBuilder builder) {
        super(builder);
        time = builder.time;
        zone = time.atZone(builder.zone.id);
    }


    @Override
    public String toString() {
        return time.format(DateTimeFormatter.ofPattern(Format.DEFAULT.format()));
    }
    public static class LocalTimeBuilder extends Time.Builder<LocalTimeBuilder> {

        private TimeZone zone;
        private LocalDateTime time;
        public LocalTimeBuilder() {
            super();
        }

        public LocalTimeBuilder zone(TimeZone zone) {
            this.zone = zone;
            return this;
        }
        public LocalTimeBuilder time(LocalDateTime time) {
            this.time = time;
            return this;
        }
        @Override
        public LocalTime build() {
            if (this.zone == null) {
                this.zone = TimeZone.DEFAULT;
            }
            return new LocalTime(this);
        }

        @Override
        protected LocalTimeBuilder me() {
            return this;
        }
    }

    public static LocalTime create(LocalTime time, TimeZone zone) {
        // タイムゾーン変換
        var newZone = time.zone.withZoneSameInstant(zone.id);
        var newTime = newZone.toLocalDateTime();
        return new LocalTimeBuilder()
                .time(newTime)
                .zone(zone)
                .build();
        // ↓だけに変換するメソッドが欲しいかも
//                withZoneSameInstant(zone.id);
    }
//    public  LocalDateTime create(String time, Consts fmt) {
//        LocalDateTime.parse(time, LocalDateTime.of(fmt));
//    }
    public static LocalDateTime now(){
        return LocalDateTime.now();
    }

    public static String of(LocalTime localtime, Consts.Format fmt) {
        return localtime.time.format(DateTimeFormatter.ofPattern(fmt.toString()));
    }
}
