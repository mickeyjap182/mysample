package practice.basicfeature.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class A002SieveOfEratosthenesTest {
    @Test
    public void testFactorial(){
        A002SieveOfEratosthenes s = new A002SieveOfEratosthenes();


        Map<Integer, Integer> result = s.main(0, 100);
        assertEquals(
                20,
                result.values().stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
                        .size()
        );
        System.out.println(s.format(result));
    }
}
