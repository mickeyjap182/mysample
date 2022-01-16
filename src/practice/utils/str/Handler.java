package practice.utils.str;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Handler {

    public final String pathSep;
    public final String value;

    public Handler(String value) {
        this.value = value;
        // default
        this.pathSep  = "/";
    }
    public String tail(String delimiter) {
        if (Objects.isNull(delimiter)) delimiter = this.pathSep;
        return StringUtils.substringAfterLast(value, "/");
    }
}
