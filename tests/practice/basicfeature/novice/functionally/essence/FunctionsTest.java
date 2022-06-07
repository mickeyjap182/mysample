package practice.basicfeature.novice.functionally.essence;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.ToLongFunction;
import java.util.stream.Stream;

public class FunctionsTest {
    @Test
    public void testFunctions() {
        Functions f = new Functions();
        ToLongFunction lf = f.longFunc();
        System.out.println(lf.applyAsLong(30L));

        int intRet = Functions.intFunc().applyAsInt(30);
        System.out.println(intRet);

        Stream a = Arrays.stream(new Object[] {1,2,3,4,5}).map(x -> Functions.intFunc().applyAsInt(x));
        a.forEach(System.out::println);
        int ret = (int)a.reduce( (x, y) -> (int)x + (int)y).orElse(0);
        System.out.println(ret);


    }

}