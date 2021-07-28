package practice.basicfeature.algorithm;

import org.junit.jupiter.api.Test;

import java.util.SortedMap;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class A002SieveOfEratosthenesTest {
    @Test
    public void testRun(){
        A002SieveOfEratosthenes s = new A002SieveOfEratosthenes();


        SortedMap<Integer, Boolean> result = s.main(0, 100);
        System.out.println(s.format(result));
        assertEquals(
                25,
                result.values().stream()
                        .filter(v -> v)
                        .collect(Collectors.toList())
                        .size()
        );
    }
}
