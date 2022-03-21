package practice.basicfeature.novice.functionally;

import org.junit.jupiter.api.Test;
import practice.basicfeature.novice.functionally.essence.Predicators;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicatorTest {
    @Test
    public void test_go() {
        try {
            Predicators<Integer> p = new Predicators<>(i -> i > 0);
            Predicate<Integer> y1 = p.gt10();
            BiPredicate<String, String> y2 = p.isOverLength5();


            System.out.println(y1.test(20));
            System.out.println(y2.test("1", "周年"));
            System.out.println(y2.test("100000000", "周年"));
            System.out.println("10000周年".length());


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}