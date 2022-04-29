package practice.utils.env.locale;

import java.util.Locale;

public class LocaleConfigure {

    public LocaleConfigure() {
        // TODO: String.formatに影響する。
        Locale.setDefault(Locale.JAPAN);
    }
}
