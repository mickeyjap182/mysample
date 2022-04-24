package practice.basicfeature.novice.functionally.essence;

import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Functions {

    public static ToLongFunction longFunc() {
        ToLongFunction f = (x) -> {
          return (long)x + 20L;
        };
        return f;
    }
    public static ToIntFunction intFunc() {
        ToIntFunction f = (x) -> (int)x + 20;

        return f;
    }
}
