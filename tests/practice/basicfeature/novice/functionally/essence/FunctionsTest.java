package practice.basicfeature.novice.functionally.essence;

import org.junit.jupiter.api.Test;

import java.util.function.ToLongFunction;

public class FunctionsTest {
    @Test
    public void testFunctions() {
        Functions f = new Functions();
        ToLongFunction lf = f.longFunc();
        System.out.println(lf.applyAsLong(30L));

    }

}