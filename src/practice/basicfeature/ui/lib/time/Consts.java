package practice.basicfeature.ui.lib.time;

import java.time.ZoneId;
import java.time.ZoneOffset;

public class Consts {
    public enum Format {
        DEFAULT("yyyy-MM-dd HH:mm:ss");

        private final String fmt;

        Format(String fmt) {
            this.fmt = fmt;
        }

        String format() {
            return fmt;
        }
    }
    enum TimeZone {
        DEFAULT(ZoneId.of("Asia/Tokyo")),
        TOKYO(ZoneId.of("Asia/Tokyo")),
        SGP(ZoneId.of("Asia/Singapore")),
        UTC(ZoneOffset.UTC);

        public ZoneId id;
        TimeZone(ZoneId id) {
            this.id = id;
        }
        // ZoneOffset.JST
    }

}
