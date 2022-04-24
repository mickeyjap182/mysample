package practice.basicfeature.novice.functionally.essence;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class ComparerTest {
    @Test
    public void testMonkey() {
        var ret =  new Comparer("aaa").sort();
        Stream.of("a", "b");
        final Function<Map.Entry, Stream> f = v -> Stream.of(v.getKey().toString(), v.getValue());
        ret.entrySet().stream()
                .flatMap(e -> Stream.of(e.getKey(), e.getValue()))
                .forEach(System.out::println);
    }

}